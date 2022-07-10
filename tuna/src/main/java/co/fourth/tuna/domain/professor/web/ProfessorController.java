package co.fourth.tuna.domain.professor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.professor.service.ProfessorService;
import co.fourth.tuna.domain.professor.vo.ProfessorVO;

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
	
}
