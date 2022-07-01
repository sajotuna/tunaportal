package co.fourth.tuna;

import java.util.Locale;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@RequestMapping("/coursesreg")
	public String coursesReg() {
		return "coursesreg";
	}

	// 페이지 매핑
	@GetMapping("/captcha.do")
	public String Captcha() {
		return "captcha";
	}

	// captcha 이미지 가져오는 메서드
	@GetMapping("/captchaImg.do")
	@ResponseBody
	public void captchaImg(HttpServletRequest req, HttpServletResponse res) throws Exception {
		new CaptchaUtil().getImgCaptCha(req, res);
	}

	// 전달받은 문자열로 음성 가져오는 메서드
	@GetMapping("/captchaAudio.do")
	@ResponseBody
	public void captchaAudio(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String getAnswer = captcha.getAnswer();
		new CaptchaUtil().getAudioCaptCha(req, res, getAnswer);
	}

	// 사용자가 입력한 보안문자 체크하는 메서드
	@PostMapping("/chkAnswer.do")
	@ResponseBody
	public String chkAnswer(HttpServletRequest req, HttpServletResponse res) {
		String result = "";
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String ans = req.getParameter("answer");
		if (ans != null && !"".equals(ans)) {
			if (captcha.isCorrect(ans)) {
				req.getSession().removeAttribute(Captcha.NAME);
				result = "200";
			} else {
				result = "300";
			}
		}
		return result;
	}

}
