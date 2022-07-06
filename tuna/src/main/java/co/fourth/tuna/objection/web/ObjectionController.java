package co.fourth.tuna.objection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ObjectionController {
	
	@RequestMapping("/objectionList")
	public String objectionList() {
		return "portal/eclassProf/objectionList";
	}
}
