package co.fourth.tuna;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home")
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping("/")
	public String homepage(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/logout")
	public void logout() {
		logger.info("Logout");
	}
	
	@RequestMapping("/custom/login")
	public String login() {
		return "custom/login";
	}
	
	@RequestMapping("/duplicatelogin")
	public String duplicateLogin(Model model) {
		model.addAttribute("LoginFailMessage", "다른 IP에서 접속하셨기 때문에 기존의 접속이 끊어집니다.");
		return "custom/login";
	}
	
	@RequestMapping("/mypage")
	public String home() {
		return "mypage";
	}
	
}
