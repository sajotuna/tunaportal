package co.fourth.tuna.web.eclass.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.web.eclass.EclassController;

@Controller
@RequestMapping("/eclass/student")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
}
