package co.fourth.tuna.domain.scholar.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.scholar.service.ScholarService;
import co.fourth.tuna.domain.scholar.vo.ScholarApplyVO;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class ScholarController {
	
	@Autowired
	private StudentService StudentDao;

	@Autowired
	private SqlSession SqlSession;
	
	@Autowired
	private ScholarService ScholarDao;
	
	@Autowired
	private FileService fileService;

	@Autowired
	private String fileDir;
	
	
	@RequestMapping("/stud/scholarshipApplicationStatus")
	public String scholarshipApplicationStatus(Model model,ScholarApplyVO vo,Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode("105");
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.ScholarCheck", vo);
		
		model.addAttribute("list", lists);
		return "scholarship/user/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarshipApplication")
	public String courseBasket(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "scholarship/user/scholarshipApplication";
	}
	
	@RequestMapping("/stud/scolarShipApply")
	public String ScolarShipApply(Model model, ScholarApplyVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		ScholarDao.ScholarApply(vo);
		
		return "redirect:/stud/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarFileUpload")
	public String scholarFileUpload(ScholarApplyVO vo,@RequestParam(value = "file") MultipartFile file) {
		
		String[] scholarFile = fileService.upload(file, "ScholarFile");
		vo.setFileName(scholarFile[0]);
		vo.setUri(scholarFile[1]);
		ScholarDao.FileUpLoad(vo);
		
		return "redirect:/stud/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarDelete")
	public String scholarDelete(RedirectAttributes ra,ScholarApplyVO vo) {
		
		ScholarDao.ScholarDelete(vo);
		ra.addFlashAttribute("message", "삭제가 완료되었습니다.");
		return "redirect:/stud/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarshipApplicationSearch")
	public String scholarshipApplicationSearch(Authentication authentication,Model model,ScholarApplyVO vo, @RequestParam(value = "year", required = false, defaultValue = "") String year) {
		
		vo.setSeasonCode(year);
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.ScholarCheck", vo);
		
		model.addAttribute("list", lists);
		model.addAttribute("year", year);
		
		return "scholarship/user/scholarshipApplicationSearch";
	}
	
	@RequestMapping("/admin/adminScholarshipApplicationSearch")
	public String adminScholarshipApplicationSearch(Model model, @RequestParam Map<String, Object> params, @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {
		
		params.put("pageNum", pageNum);
		params.put("size", 10);
		
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.adminScholarCheck",params);
		
		model.addAttribute("list", lists);
		
		
		return "scholarship/admin/adminScholarshipApplicationSearch";
	}
	
	
	@RequestMapping("/admin/scholarCheck")
	public String scholarCheck(ScholarApplyVO vo, @RequestParam List<String> scholarCheckbox) {
		
		vo.setStateCode("504");
		for(String Check : scholarCheckbox) {
			vo.setNo(Check);
			ScholarDao.scholarUpdate(vo);
		}
		
		return "redirect:/admin/adminScholarshipApplicationSearch";
	}
	@RequestMapping("/admin/scholarReject")
	public String scholarReject(ScholarApplyVO vo, @RequestParam List<String> scholarCheckbox) {
		
		vo.setStateCode("503");
		for(String Check : scholarCheckbox) {
			vo.setNo(Check);
			ScholarDao.scholarUpdate(vo);
		}
		return "redirect:/admin/adminScholarshipApplicationSearch";
	}
	
	
	
	
	
	
	
	
	
	
	
}
