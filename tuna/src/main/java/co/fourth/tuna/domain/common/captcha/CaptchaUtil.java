package co.fourth.tuna.domain.common.captcha;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import nl.captcha.Captcha;
import nl.captcha.audio.AudioCaptcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

@Service
public class CaptchaUtil {
	private static int width = 150;	/*보안문자 이미지 가로크기*/
	private static int height = 50; /*보안문자 이미지 세로크기*/
	
	/*CaptCha Image 생성*/
	public void getImgCaptCha(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		/*폰트 및 컬러 설정*/
		List<Font> fontList = new ArrayList<Font>();
		fontList.add(new Font("", Font.HANGING_BASELINE, 40));
		fontList.add(new Font("Courier", Font.ITALIC, 40));
		fontList.add(new Font("", Font.PLAIN, 40));
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(Color.BLACK);
		
		Captcha captcha = new Captcha.Builder(width,  height)
				// .addText() 또는 아래와 같이 정의 : 6자리 숫자와 폰트 및 컬러 설정
				.addText(new NumbersAnswerProducer(6), new DefaultWordRenderer(colorList, fontList))
				.addNoise().addBorder()
				.addBackground(new GradiatedBackgroundProducer())
				.build();
		
		/*JSP에서 Captcha 객체에 접근할 수 있도록 session에 저장*/
		req.getSession().setAttribute(Captcha.NAME, captcha);
		CaptchaServletUtil.writeImage(res, captcha.getImage());
	}
	
	/*CaptCha Audio 생성*/
	public void getAudioCaptCha(HttpServletRequest req, HttpServletResponse res, String answer) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		String getAnswer = answer;
		
		if(getAnswer == null || getAnswer.equals("")) getAnswer = captcha.getAnswer();
		
		AudioCaptcha audiocaptcha = new AudioCaptcha.Builder()
				.addAnswer(new SetTextProducer(getAnswer))
				.addNoise()	/*잡음 추가*/
				.build();
		
		CaptchaServletUtil.writeAudio(res,  audiocaptcha.getChallenge());
	}
}
