package co.fourth.tuna.domain.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.user.service.ProfessorService;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Controller
public class ProfessorController {

	
	@Autowired 
	private ProfessorService professorDao;
	
	@RequestMapping("/professor")
	public String ProfessorInfo(Model model, ProfessorVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = professorDao.findById(vo);
		model.addAttribute("vo", vo);
		return "home";
		
	}
	
	@RequestMapping("/staff/userUpdate")
	public String userUpdate(Model model, ProfessorVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = professorDao.findById(vo);
		model.addAttribute("vo", vo);
		
		return "manage/user/professorUpdate";
		
	}
	
	@RequestMapping("/staff/proInfoUpdate")
	public String proInfoUpdate(ProfessorVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		professorDao.profUpdate(vo);
		return "redirect:/staff/userUpdate";
	}
	
	@RequestMapping("/admin/AdminproUpdate")
	public String AdminproUpdate(ProfessorVO vo,RedirectAttributes ra) {
		
		professorDao.AdminProfUpdate(vo);
		ra.addAttribute("no", vo.getNo());
		return "redirect:/admin/adminUserInfo";
	}
	
	
}
