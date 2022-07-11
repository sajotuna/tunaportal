package co.fourth.tuna.util.security;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		logger.info("Login Success");
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		if(authentication.getName().length() == 8) {
			response.sendRedirect("student");
		}else if(authentication.getName().length() == 6) {
			response.sendRedirect("admin");
		}else if(authentication.getName().length() == 5) {
			response.sendRedirect("professor");
		}
		
		
	}

}
