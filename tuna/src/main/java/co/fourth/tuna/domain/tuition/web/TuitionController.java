package co.fourth.tuna.domain.tuition.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.tuition.service.TuitionService;
import co.fourth.tuna.domain.tuition.vo.tuitionGiveVO;

@Controller
public class TuitionController {

	@Autowired private TuitionService tuitionDao;
	
	@RequestMapping("/stud/tuitionCheck")
	public String adminScholarshipApplicationSearch(Model model, Authentication authentication, tuitionGiveVO vo) {
		
		vo.setStNo(Integer.parseInt(authentication.getName()));
		vo.setSeasonCode("106");
		
		model.addAttribute("vo", tuitionDao.tuitionCheck(vo));
	
		
		return "scholarship/user/tuitionCheck";
	}
	
	
}
