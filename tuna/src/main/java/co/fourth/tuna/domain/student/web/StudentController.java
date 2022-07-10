package co.fourth.tuna.domain.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.student.service.StudentService;
import co.fourth.tuna.domain.student.vo.StudentVO;

@Controller
public class StudentController {
	
	@Autowired 
	private StudentService StudentDao;
	
	
	@RequestMapping("/student")
	public String Student(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		
		model.addAttribute("vo", vo);
		return "home";
	}

	@RequestMapping("/admin/adminUserSearch")
	public String adminUserSearch() {
		return "manage/admin/adminUserSearch";
	}
	@RequestMapping("/admin/adminUserInfo")
	public String adminUserInfo() {
		return "manage/admin/adminUserInfo";
	}
	
}
