package co.fourth.tuna.domain.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class StudentController {
	
	@Autowired 
	private StudentService StudentDao;


	@RequestMapping("/stud/userUpdate")
	public String userUpdate(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "manage/user/userUpdate";
	}
	
	@RequestMapping("/stud/userInfoUpdate")
	public String userInfoUpdate(StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		StudentDao.studUpdate(vo);
		return "redirect:/stud/userUpdate";
	}
	
	@RequestMapping("/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/pwdUpdate";
	}
	
	@RequestMapping("/admin/AdminUserUpdate")
	public String AdminUserUpdate(StudentVO vo,RedirectAttributes ra) {
		StudentDao.AdminStudUpdate(vo);
		ra.addAttribute("no", vo.getNo());
		return "redirect:/admin/adminUserInfo";
	}
	
	
}
