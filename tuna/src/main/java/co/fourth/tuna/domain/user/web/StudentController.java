package co.fourth.tuna.domain.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

	@RequestMapping("/stud/userUpdate")
	public String userUpdate(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "manage/user/userUpdate";
	}
	
	@RequestMapping("/stud/userInfoUpdate")
	public String userInfoUpdate(RedirectAttributes ra,StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		StudentDao.studUpdate(vo);
		ra.addFlashAttribute("success", "회원정보가 수정되었습니다.");
		return "redirect:/stud/userUpdate";
	}
	
	@RequestMapping("/stud/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/pwdUpdate";
	}
	
	@RequestMapping("/admin/AdminUserUpdate")
	public String AdminUserUpdate(StudentVO vo,RedirectAttributes ra) {
		StudentDao.AdminStudUpdate(vo);
		ra.addAttribute("no", vo.getNo());
		ra.addFlashAttribute("success", "회원정보가 수정되었습니다.");
		return "redirect:/admin/adminUserInfo";
	}
	
	@RequestMapping("/stud/userpwdUpdate")
	public String userpwdUpdate(RedirectAttributes ra,Model model, String beforepassword, StudentVO vo){
		String oldpwd = StudentDao.findStudPwd(vo);
		String message = "";
		if(enc.matches(beforepassword,oldpwd)) {
			vo.setPwd(enc.encode(vo.getPwd()));
			StudentDao.studPwdUpdate(vo);
			message = "비밀번호가 변경 되었습니다.";
		}else {
			message = "비밀번호가 틀립니다.";
			ra.addFlashAttribute("error", message);
			return "redirect:/stud/pwdUpdate";
		}
		ra.addFlashAttribute("success", message);
		return "redirect:/stud/pwdUpdate";
	}
	
	
}
