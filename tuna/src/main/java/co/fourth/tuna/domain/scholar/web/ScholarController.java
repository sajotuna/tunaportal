package co.fourth.tuna.domain.scholar.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.common.service.YearService;
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
	private YearService yearDao; 
	
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
		ra.addFlashAttribute("success", "삭제가 완료되었습니다.");
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
		

		if(params.get("applydate") != null && !params.get("applydate").equals("")) {
			String Date = (String)params.get("applydate");
			System.out.println(Date.substring(0, Date.indexOf(" ")) +"~"+ (Date.substring(Date.lastIndexOf(" "),Date.length())).trim());
			
			params.put("startDate", Date.substring(0, Date.indexOf(" ")));
			params.put("endDate", (Date.substring(Date.lastIndexOf(" "),Date.length())).trim());
		}
		
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.adminScholarCheck",params);
		
		
		
		model.addAttribute("list", lists);
		model.addAttribute("params", params);
		
		return "scholarship/admin/adminScholarshipApplicationSearch";
	}
	
	
	@RequestMapping("/admin/scholarCheck")
	public String scholarCheck(RedirectAttributes ra,ScholarApplyVO vo, @RequestParam List<String> scholarCheckbox, @RequestParam List<String> seasonCode) {
		
		vo.setStateCode("504");
		String year = yearDao.yearFind();
		for(int i =0; i<scholarCheckbox.size(); i++) {
			vo.setNo(scholarCheckbox.get(i));
			if(year.equals(seasonCode.get(i))) {
				ScholarDao.scholarUpdate(vo);
			}
			else {
				ra.addFlashAttribute("error", "지난학기에 신청한 장학금내역은 변경이 불가능합니다.");
				return "redirect:/admin/adminScholarshipApplicationSearch";
			}
		}
		
		return "redirect:/admin/adminScholarshipApplicationSearch";
	}
	@RequestMapping("/admin/scholarReject")
	public String scholarReject(RedirectAttributes ra,ScholarApplyVO vo, @RequestParam List<String> scholarCheckbox, @RequestParam List<String> seasonCode) {
		
		vo.setStateCode("503");
		String year = yearDao.yearFind();
		for(int i =0; i<scholarCheckbox.size(); i++) {
			vo.setNo(scholarCheckbox.get(i));
			if(year.equals(seasonCode.get(i))) {
				ScholarDao.scholarUpdate(vo);
			}
			else {
				ra.addFlashAttribute("error", "지난학기에 신청한 장학금내역은 변경이 불가능합니다.");
				return "redirect:/admin/adminScholarshipApplicationSearch";
			}
		}
		return "redirect:/admin/adminScholarshipApplicationSearch";
	}
	
	
	
	
	@ResponseBody
	@GetMapping("/stud/scholarApplyCheck")
	public List<ScholarApplyVO> scholarApplyCheck(ScholarApplyVO vo,Authentication authentication) {
		vo.setStNo(authentication.getName());
		return ScholarDao.scholarApplyCheck(vo);
	}
	
	
	
	
	
	
	
	
}
