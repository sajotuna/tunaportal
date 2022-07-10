package co.fourth.tuna.web.eclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eclass")
public class EclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping("/")
	public void Eclass() {
		//return "eclass/"+path;
		logger.info("elcass controller test");
	}
}
