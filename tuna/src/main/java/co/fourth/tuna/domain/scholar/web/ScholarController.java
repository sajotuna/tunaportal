package co.fourth.tuna.domain.scholar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class ScholarController {
	
	@Autowired
	private StudentService StudentDao;

	@RequestMapping("/stud/scholarshipApplicationStatus")
	public String scholarshipApplicationStatus() {
		return "scholarship/user/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarshipApplication")
	public String courseBasket(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "scholarship/user/scholarshipApplication";
	}
	
	@RequestMapping("/scolarShipApply")
	public String ScolarShipApply(Model model, String scol) {
		System.out.println(scol);
		
		return "scholarship/user/scholarshipApplicationStatus";
	}
	
	@RequestMapping("/stud/scholarshipApplicationSearch")
	public String scholarshipApplicationSearch() {
		return "scholarship/user/scholarshipApplicationSearch";
	}
	
	@RequestMapping("/admin/adminScholarshipApplicationSearch")
	public String adminScholarshipApplicationSearch() {
		return "scholarship/admin/adminScholarshipApplicationSearch";
	}
	
}
