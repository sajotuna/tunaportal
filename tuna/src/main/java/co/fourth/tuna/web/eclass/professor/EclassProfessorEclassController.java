package co.fourth.tuna.web.eclass.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.web.eclass.EclassController;

@Controller
@RequestMapping("/eclass/professor")
public class EclassProfessorEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
}
