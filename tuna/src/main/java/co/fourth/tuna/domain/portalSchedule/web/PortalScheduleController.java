package co.fourth.tuna.domain.portalSchedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalScheduleController {

	//student
	@RequestMapping("/portalSchedule")
	public String portalSchedule() {
		return "schedule/user/portalSchedule";
	}
	
	//admin
	@RequestMapping("/admin/adminSchedule")
	public String adminSchedule() {
		return "schedule/admin/adminSchedule";
	}
}
