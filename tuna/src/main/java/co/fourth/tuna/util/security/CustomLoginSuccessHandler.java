package co.fourth.tuna.util.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.fourth.tuna.domain.user.vo.StudentVO;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String name = authentication.getName();
		StudentVO vo = (StudentVO)authentication.getPrincipal();
		request.getSession().setAttribute("suser", vo);
		response.sendRedirect("home");
		
		
	}

}
