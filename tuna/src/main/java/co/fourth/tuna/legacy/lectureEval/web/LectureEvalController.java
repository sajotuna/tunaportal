package co.fourth.tuna.legacy.lectureEval.web;

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
	
}
