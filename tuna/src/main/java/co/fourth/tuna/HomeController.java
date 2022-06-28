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
	
	@RequestMapping("/logout")
	public void logout() {
		logger.info("Logout");
	}
	
	@RequestMapping("/custom/login")
	public String login() {
		return "custom/login";
	}
	
	@RequestMapping("/custom/processLogin")
	public String proocessLogin() {
		return "home";
	}
	
	
}
