package co.fourth.tuna.domain.grade.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GradeController {

	// 당해학기 성적 조회 페이지 이동
	@RequestMapping("/stud/currentSemesterGrade")
	public String currentSemesterGrade() {
		return "portal/stud/currentSemesterGrade";
	}
}
