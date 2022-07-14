package co.fourth.tuna.domain.portalSchedule.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

@Controller
public class PortalScheduleController {

	@Autowired
	private PortalScheduleService scheduleDao;
	
	
	//student
	@RequestMapping("/portalSchedule")
	@ResponseBody
	public String portalSchedule(PortalScheduleVO vo, Model model){
	model.addAttribute("schedules", scheduleDao.scheduleList(vo));
	return "schedule/user/portalSchedule.html";
	}
	
	
	//admin
	@RequestMapping("/admin/adminSchedule")
	public String adminSchedule() {
		return "schedule/admin/adminSchedule";
	}
}
