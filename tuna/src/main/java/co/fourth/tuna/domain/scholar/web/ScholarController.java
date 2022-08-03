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

import co.fourth.tuna.domain.common.service.DateCheckService;
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
	@Autowired
	private DateCheckService DataDao;

	@RequestMapping("/stud/scholar/Status")
	public String scholarshipApplicationStatus(Model model, ScholarApplyVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.ScholarCheck", vo);

		model.addAttribute("list", lists);
		return "scholarship/user/scholarshipApplicationStatus";
	}

	@RequestMapping("/stud/scholar/Application")
	public String courseBasket(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "scholarship/user/scholarshipApplication";
	}

	@RequestMapping("/stud/scholar/Apply")
	public String ScolarShipApply(RedirectAttributes ra, Model model, ScholarApplyVO vo,
			Authentication authentication) {

//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1107") != 1) {
//			ra.addFlashAttribute("error", "현재 장학금 신청기간이 아닙니다.");
//			return "redirect:/stud/scholar/Application";
//		}

		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.ScholarApply(vo);
		
		if(vo.getSchNo().equals("1")) {
			ra.addFlashAttribute("success", "장학금신청이 완료되었습니다.");
			return "redirect:/stud/scholar/Status";
		}else {
			ra.addFlashAttribute("success", "장학금신청이 완료되었습니다. 파일을 제출해주세요.");
			return "redirect:/stud/scholar/Status";
		}
	}

	@RequestMapping("/stud/scholar/FileUpload")
	public String scholarFileUpload(RedirectAttributes ra, ScholarApplyVO vo,
			@RequestParam(value = "file") MultipartFile file) {
//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1107") != 1) {
//			ra.addFlashAttribute("error", "현재 장학금 신청기간이 아닙니다.");
//			return "redirect:/stud/scholar/Status";
//		}

		String[] scholarFile = fileService.upload(file, "ScholarFile");
		vo.setFileName(scholarFile[0]);
		vo.setUri(scholarFile[1]);
		ScholarDao.FileUpLoad(vo);

		ra.addFlashAttribute("success", "파일등록이 완료되었습니다.");
		return "redirect:/stud/scholar/Status";
	}

	@RequestMapping("/stud/scholar/Delete")
	public String scholarDelete(RedirectAttributes ra, ScholarApplyVO vo) {

//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1107") != 1) {
//			ra.addFlashAttribute("error", "현재 장학금 신청기간이 아닙니다.");
//			return "redirect:/stud/scholar/Status";
//		}

		ScholarDao.ScholarDelete(vo);
		ra.addFlashAttribute("success", "장학신청 삭제가 완료되었습니다.");
		return "redirect:/stud/scholar/Status";
	}

	@RequestMapping("/stud/scholar/Search")
	public String scholarshipApplicationSearch(Authentication authentication, Model model, ScholarApplyVO vo,
			@RequestParam(value = "year", required = false, defaultValue = "") String year) {

		vo.setSeasonCode(year);
		vo.setStNo(authentication.getName());
		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.ScholarCheck", vo);

		model.addAttribute("list", lists);
		model.addAttribute("year", year);

		return "scholarship/user/scholarshipApplicationSearch";
	}

	@RequestMapping("/admin/admin/scholarSearch")
	public String adminScholarshipApplicationSearch(Model model, @RequestParam Map<String, Object> params,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {

		params.put("pageNum", pageNum);
		params.put("size", 10);

		if (params.get("applydate") != null && !params.get("applydate").equals("")) {
			String Date = (String) params.get("applydate");
			System.out.println(Date.substring(0, Date.indexOf(" ")) + "~"
					+ (Date.substring(Date.lastIndexOf(" "), Date.length())).trim());

			params.put("startDate", Date.substring(0, Date.indexOf(" ")));
			params.put("endDate", (Date.substring(Date.lastIndexOf(" "), Date.length())).trim());
		}

		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.scholar.mapper.ScholarMapper.adminScholarCheck", params);

		model.addAttribute("list", lists);
		model.addAttribute("params", params);

		return "scholarship/admin/adminScholarshipApplicationSearch";
	}

	@RequestMapping("/admin/scholar/success")
	public String scholarCheck(RedirectAttributes ra, ScholarApplyVO vo,
			@RequestParam(defaultValue = "") List<String> scholarCheckbox) {
		
//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1108") != 1) {
//		ra.addFlashAttribute("error", "현재 장학금 신청기간이 아닙니다.");
//		return "redirect:/stud/scholar/Status";
//	}
		
		if (scholarCheckbox.isEmpty()) {
			ra.addFlashAttribute("error", "심사에 통과할 학생을 선택해주세요.");
			return "redirect:/admin/admin/scholarSearch";
		}
		vo.setStateCode("504");
		String year = yearDao.yearFind();
		String[] box = new String[2];
			for (int i = 0; i < scholarCheckbox.size(); i++) {
				
				if(i== 0) {
					box = scholarCheckbox.toString().replaceAll("[^,0-9]", "").split(",");
				}else {
					box = scholarCheckbox.get(i).split(",");
				}
				
				if(box.length<2) {
					break;
				}
				
				vo.setNo(box[0]);
				System.out.println(box[1].equals(year));
				if (box[1].equals(year)) {
					ScholarDao.scholarUpdate(vo);
				} else {
					ra.addFlashAttribute("error", "지난학기에 신청한 장학금내역은 변경이 불가능합니다.");
					return "redirect:/admin/admin/scholarSearch";
				}
				
				
				
			}
		ra.addFlashAttribute("success", "선택한 학생들의 장학 심사가 통과되었습니다.");
		return "redirect:/admin/admin/scholarSearch";
	}

	@RequestMapping("/admin/scholar/reject")
	public String scholarReject(RedirectAttributes ra, ScholarApplyVO vo,
			@RequestParam(defaultValue = "") List<String> scholarCheckbox) {
//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1108") != 1) {
//		ra.addFlashAttribute("error", "현재 장학금 신청기간이 아닙니다.");
//		return "redirect:/stud/scholar/Status";
//	}
		if (scholarCheckbox.isEmpty()) {
			ra.addFlashAttribute("error", "심사를 거절할 학생을 선택해주세요.");
			return "redirect:/admin/admin/scholarSearch";
		}
		vo.setStateCode("503");
		String year = yearDao.yearFind();
		String[] box = new String[2];
			for (int i = 0; i < scholarCheckbox.size(); i++) {
				if(i== 0) 
					box = scholarCheckbox.toString().replaceAll("[^,0-9]", "").split(",");
				else 
					box = scholarCheckbox.get(i).split(",");
				vo.setNo(box[0]);
				if(box.length<2) 
					break;
				if (box[1].equals(year)) {
					ScholarDao.scholarUpdate(vo);
				} else {
					ra.addFlashAttribute("error", "지난학기에 신청한 장학금내역은 변경이 불가능합니다.");
					return "redirect:/admin/admin/scholarSearch";
				}
			}
		ra.addFlashAttribute("success", "선택한 학생들의 장학 심사가 거절되었습니다.");
		return "redirect:/admin/admin/scholarSearch";
	}

	@ResponseBody
	@GetMapping("/stud/scholar/ApplyCheck")
	public List<ScholarApplyVO> scholarApplyCheck(ScholarApplyVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		return ScholarDao.scholarApplyCheck(vo);
	}

}
