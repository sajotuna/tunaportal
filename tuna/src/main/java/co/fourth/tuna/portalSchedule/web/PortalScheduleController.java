package co.fourth.tuna.portalSchedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalScheduleController {

	@RequestMapping("/portalSchedule")
	public String portalSchedule() {
		return "portal/extra/portalSchedule";
	}
}
