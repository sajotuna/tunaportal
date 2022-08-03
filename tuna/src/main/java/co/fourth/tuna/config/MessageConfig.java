package co.fourth.tuna.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:config/message");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(60); // 파일 내용 변경 감지 후 리로드
		messageSource.setUseCodeAsDefaultMessage(true); // 매핑된 값을 찾지 못할 시 들어온 코드 값 그대로 출력
		
		return messageSource;
	}
	
	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource());
		
		return messageSourceAccessor;
	}
}
