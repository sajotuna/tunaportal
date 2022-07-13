package co.fourth.tuna.web.portal.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalStudentController {
	
	// 강의/성적 조회 페이지로 이동
	@RequestMapping("/stud/subjectAndReport")
	public String subjectAndRoport() {
		
		return "portal/stud/subjectAndReport";
	}
	
}
