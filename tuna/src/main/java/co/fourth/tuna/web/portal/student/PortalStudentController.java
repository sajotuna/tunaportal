package co.fourth.tuna.web.portal.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalStudentController {

	// 당해학기 성적 조회 페이지 이동
	@RequestMapping("/stud/currentSemesterGrade")
	public String currentSemesterGrade() {
		return "portal/stud/currentSemesterGrade";
	}
	
}
