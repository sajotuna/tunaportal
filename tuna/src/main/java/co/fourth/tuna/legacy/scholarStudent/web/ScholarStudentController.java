package co.fourth.tuna.legacy.scholarStudent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScholarStudentController {

	@RequestMapping("/stud/scholarshipApplicationSearch")
	public String scholarshipApplicationSearch() {
		return "scholarship/user/scholarshipApplicationSearch";
	}
	@RequestMapping("/admin/adminScholarshipApplicationSearch")
	public String adminScholarshipApplicationSearch() {
		return "scholarship/admin/adminScholarshipApplicationSearch";
	}
	
}
