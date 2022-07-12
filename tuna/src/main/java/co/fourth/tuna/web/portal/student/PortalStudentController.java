package co.fourth.tuna.web.portal.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalStudentController {
	
	@RequestMapping("/stud/subjectAndReport")
	public String subjectAndRoport() {
		return "portal/stud/subjectAndReport";
	}
	
}
