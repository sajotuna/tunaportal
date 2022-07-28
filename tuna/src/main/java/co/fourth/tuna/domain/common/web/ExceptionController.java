package co.fourth.tuna.domain.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

	
	
	@RequestMapping("/error/404.html")
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	 public String resourceNotFound(){
		 return "error/404";
	 }
	
	@RequestMapping("/error/403")
	public String Error403() {
		return "error/403";
	}
	
}
