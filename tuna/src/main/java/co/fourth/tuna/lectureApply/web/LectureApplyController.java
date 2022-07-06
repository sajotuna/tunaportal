package co.fourth.tuna.lectureApply.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureApplyController {
	
	@RequestMapping("/stud/courseWarning")
	public String courseWarning() {
		return "course/apply/courseWarning";
	}
	
	@RequestMapping("/stud/courseApplication")
	public String courseApplication() {
		return "course/apply/courseApplication";
	}
	
	@RequestMapping("/stud/courseApplicationLectureList")
	public String courseApplicationLectureList() {
		return "course/apply/courseApplicationLectureList";
	}
	
	@RequestMapping("/stud/courseApplicationSchedule")
	public String courseApplicationSchedule() {
		return "course/apply/courseApplicationSchedule";
	}
}
