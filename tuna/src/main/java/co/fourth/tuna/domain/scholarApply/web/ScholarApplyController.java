package co.fourth.tuna.domain.scholarApply.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScholarApplyController {

	@RequestMapping("/stud/scholarshipApplication")
	public String courseBasket() {
		return "scholarship/user/scholarshipApplication";
	}
}
