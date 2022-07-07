package co.fourth.tuna.objection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ObjectionController {
	
	@RequestMapping("/staff/objectionList")
	public String objectionList() {
		return "objection/staff/objectionList";
	}
}
