package co.fourth.tuna.domain.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.user.service.ProfessorService;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class ProfessorController {

	
	@Autowired 
	private ProfessorService professorDao;
	
	@Autowired
	private BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

	
	@RequestMapping("/staff/userUpdate")
	public String userUpdate(Model model, ProfessorVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = professorDao.findById(vo);
		model.addAttribute("vo", vo);
		
		return "manage/user/staffUpdate";
		
	}
	
	@RequestMapping("/staff/proInfoUpdate")
	public String proInfoUpdate(RedirectAttributes ra,ProfessorVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		professorDao.profUpdate(vo);
		ra.addFlashAttribute("success", "회원정보가 수정되었습니다.");
		return "redirect:/staff/userUpdate";
	}
	
	@RequestMapping("/staff/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/staffPwdUpdate";
	}
	
	@RequestMapping("/staff/staffpwdUpdate")
	public String staffpwdUpdate(RedirectAttributes ra,Model model, String beforepassword, ProfessorVO vo){
		String oldpwd = professorDao.findStaffPwd(vo);
		String message = "";
		if(enc.matches(beforepassword,oldpwd)) {
			vo.setPwd(enc.encode(vo.getPwd()));
			professorDao.staffPwdUpdate(vo);
			message = "비밀번호가 변경 되었습니다.";
		}else {
			message = "비밀번호가 틀립니다.";
			ra.addFlashAttribute("error", message);
			return "redirect:/staff/pwdUpdate";
		}
		ra.addFlashAttribute("success", message);
		return "redirect:/staff/pwdUpdate";
	}
	
	@RequestMapping("/admin/AdminproUpdate")
	public String AdminproUpdate(ProfessorVO vo,RedirectAttributes ra) {
		
		professorDao.AdminProfUpdate(vo);
		ra.addAttribute("no", vo.getNo());
		ra.addFlashAttribute("success", "회원정보가 수정되었습니다.");
		return "redirect:/admin/admin/userInfo";
	}
	
	
	
	
	
}
