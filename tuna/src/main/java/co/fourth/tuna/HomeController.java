package co.fourth.tuna;


import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.user.service.AdminService;
import co.fourth.tuna.domain.user.service.ProfessorService;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.AdminVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.domain.user.vo.StudentVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired 
	private StudentService StudentDao;
	@Autowired
	private AdminService AdminDao;
	@Autowired
	private ProfessorService ProfessorDao;
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
	
	@Autowired
	private BannerService bannerDao;

	@RequestMapping(value = "/home")
	public String home(HttpServletResponse response ,Locale locale, Model model,Authentication authentication) {
		model.addAttribute("bnList", bannerDao.sliderBannerSelect());
		return "home";
	}

//	@RequestMapping("/")
//	public String homepage(Locale locale, Model model) {
//		model.addAttribute("bnList", bannerDao.sliderBannerSelect());
//		return "home";
//	}

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

	@RequestMapping("/custom/pwdfind")
	public String pwdFind() {
		return "custom/pwdfind";
	}

	@RequestMapping("/custom/pwdEmailfind")
	public String pwdEmailFind(Model model, String email, String user) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		String authCode = null;
		String msg = "";
		StringBuffer temp = new StringBuffer();
		
		StudentVO vo = new StudentVO();
		
		
		ProfessorVO provo = new ProfessorVO();
		AdminVO adminvo = new AdminVO();
		vo.setEmail(email);
		provo.setEmail(email);
		adminvo.setEmail(email);
		
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				temp.append((rnd.nextInt(10)));
				break;
			}
		}

		authCode = temp.toString();
		
		boolean emailCheck = StudentDao.findEmail(vo);
		boolean staffEmailCheck = ProfessorDao.findEmail(provo);
		boolean AdminEmailCheck = AdminDao.findEmail(adminvo);
		
		
		if(Integer.parseInt(user) == 1 && emailCheck == true) {
			vo.setPwd(enc.encode(authCode));
			StudentDao.studEamilPwdUpdate(vo);
			
		}else if(Integer.parseInt(user) == 2 && staffEmailCheck == true) {
			provo.setPwd(enc.encode(authCode));
			ProfessorDao.staffEamilPwdUpdate(provo);
		}
		else if(Integer.parseInt(user) == 3 && AdminEmailCheck == true) {
			adminvo.setPwd(enc.encode(authCode));
			AdminDao.adminEamilPwdUpdate(adminvo);
		}else {
			msg = "없는 이메일 계정입니다. 다시 한번 확인해주세요.";
			model.addAttribute("error", msg);
			return "custom/pwdfind";
		}
		
		messageHelper.setFrom("lnsertgood123@gmail.com");
		messageHelper.setTo(vo.getEmail());
		messageHelper.setSubject("안녕하세요 TUNA대학입니다. 고객님의 임시비밀번호가 도착했습니다.");
		messageHelper.setText("임시비밀번호 : " + authCode); // 메일 내용
		mailSender.send(message);
		
		msg = "회원님의 메일으로 임시비밀번호를 보냈습니다. 확인해주세요.";
			
		model.addAttribute("success", msg);

		return "custom/pwdfind";
	}
	
}
