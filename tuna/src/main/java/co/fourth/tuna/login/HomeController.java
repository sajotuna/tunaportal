package co.fourth.tuna.login;

import java.util.Locale;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.usertest.captcha.CaptchaUtil;
import nl.captcha.Captcha;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private JavaMailSender mailSender;

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

	@RequestMapping("/custom/pwdfind")
	public String pwdFind() {
		return "custom/pwdfind";
	}

	@RequestMapping("/custom/pwdEmailfind")
	public String pwdEmailFind(String email) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		messageHelper.setFrom("lnsertgood123@gmail.com");
		messageHelper.setTo(email);
		messageHelper.setSubject("메일제목");
		messageHelper.setText("메일내용"); // 메일 내용

		mailSender.send(message);

		return "custom/pwdfind";
	}
	

	@RequestMapping("/userUpdate")
	public String userUpdate(Authentication authentication) {
		return "manage/user/userUpdate";
	}
	@RequestMapping("/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/pwdUpdate";
	}

	@RequestMapping("/custom/navExample")
	public String navExample() {
		return "custom/navExample";
	}
	
	@RequestMapping("/custom/asideExample")
	public String asideExample() {
		return "custom/asideExample";
	}

}
