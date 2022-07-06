package co.fourth.tuna.tuition.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TuitionController {

	@RequestMapping("/stud/tuitionCheck")
	public String adminScholarshipApplicationSearch() {
		return "scholarship/user/tuitionCheck";
	}
	
	
}
