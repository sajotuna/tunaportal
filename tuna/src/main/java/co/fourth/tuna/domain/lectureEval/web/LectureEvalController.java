package co.fourth.tuna.domain.lectureEval.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureEvalController {

	
	@RequestMapping("/stud/lectureEvaluation")
	public String lectureEvaluation() {
		return "course/evaluation/lectureEvaluation";
	}
	@RequestMapping("/stud/lectureEvaluationDetails")
	public String lectureEvaluationDetails() {
		return "course/evaluation/lectureEvaluationDetails";
	}
	@RequestMapping("/stud/lectureEvaluationSearch")
	public String lectureEvaluationSearch() {
		return "course/evaluation/lectureEvaluationSearch";
	}
	
	@RequestMapping("/lecture/eval")
	public String lectureEval(Authentication authentication, String sbjcode , String evaluation1, String evalContent) {
		System.out.println(sbjcode +"점수"+evaluation1+"내용"+ evalContent);
		return "close";
	}
	
}
