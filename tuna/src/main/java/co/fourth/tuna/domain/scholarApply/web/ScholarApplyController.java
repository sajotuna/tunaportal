package co.fourth.tuna.domain.scholarApply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.student.service.StudentService;
import co.fourth.tuna.domain.student.vo.StudentVO;

@Controller
public class ScholarApplyController {

	@Autowired
	private StudentService StudentDao;

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
}
