package co.fourth.tuna.scholar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScholarController {

	@RequestMapping("/stud/scholarshipApplicationStatus")
	public String scholarshipApplicationStatus() {
		return "scholarship/user/scholarshipApplicationStatus";
	}
	
}
