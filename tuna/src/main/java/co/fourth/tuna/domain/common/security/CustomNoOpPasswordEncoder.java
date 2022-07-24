package co.fourth.tuna.domain.common.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("encode 전 :" + rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("matches 수행 : " + rawPassword + "::" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
