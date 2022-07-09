package co.fourth.tuna.domain.subject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubjectController {
	
	@RequestMapping("/stud/subjectAndReport")
	public String subjectAndReport() {
		return "portal/stud/subjectAndReport";
	}
}
