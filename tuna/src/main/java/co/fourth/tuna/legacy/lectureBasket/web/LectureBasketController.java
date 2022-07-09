package co.fourth.tuna.legacy.lectureBasket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureBasketController {

	@RequestMapping("/stud/courseBasket")
	public String courseBasket() {
		return "course/basket/courseBasket";
	}
	
	@RequestMapping("/stud/courseBasketLectureList")
	public String courseBasketLectureList() {
		return "course/basket/courseBasketLectureList";
	}
	
	@RequestMapping("/stud/courseBasketSchedule")
	public String courseBasketSchedule() {
		return "course/basket/courseBasketSchedule";
	}
}
