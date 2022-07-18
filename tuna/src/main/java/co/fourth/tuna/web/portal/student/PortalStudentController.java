package co.fourth.tuna.web.portal.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.grade.service.GradeService;

@Controller
public class PortalStudentController {
	
	@Autowired GradeService gradeDao;
	
	// 강의/성적 조회 페이지로 이동
	@RequestMapping("/stud/subjectAndReport")
	public String subjectAndRoport() {
		return "portal/stud/subjectAndReport";
	}
	
	// 당해학기 성적 조회 페이지로 이동
	@RequestMapping("/stud/currentSemesterGrade")
	public String currentSemesterGrade() {
		return "portal/stud/currentSemesterGrade";
	}
	
}
