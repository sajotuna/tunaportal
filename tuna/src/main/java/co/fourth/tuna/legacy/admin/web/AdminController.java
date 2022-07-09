package co.fourth.tuna.legacy.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.legacy.admin.service.AdminService;
import co.fourth.tuna.legacy.admin.vo.AdminVO;


@Controller
public class AdminController {

	@Autowired 
	private AdminService AdminDao;
	
	@RequestMapping("/admin")
	public String Admin(Model model, AdminVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = AdminDao.findById(vo);
		model.addAttribute("vo", vo);
		return "home";
	}
	
	

}
