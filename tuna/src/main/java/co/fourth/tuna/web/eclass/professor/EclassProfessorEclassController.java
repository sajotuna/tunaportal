package co.fourth.tuna.web.eclass.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.fourth.tuna.web.eclass.EclassController;


@Controller
@RequestMapping("/eclass/professor")
public class EclassProfessorEclassController {
	
	private String path = "/eclass/professor";
	
//	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String homeView() {
		
		return path+"/home";
	}
	
	@RequestMapping({"notice"})
	public String noticeView() {
		return path+"/notice";
	}
	
	
	
}
