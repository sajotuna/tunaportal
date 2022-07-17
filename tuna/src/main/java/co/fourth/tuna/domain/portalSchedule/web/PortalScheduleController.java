package co.fourth.tuna.domain.portalSchedule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

@Controller
public class PortalScheduleController {

	@Autowired
	private PortalScheduleService scheduleDao;
	
	
	//user
	@RequestMapping("/portalSchedule")
	public String portalSchedule(PortalScheduleVO vo, Model model){
	model.addAttribute("schedules", scheduleDao.scheduleList(vo));
	return "schedule/user/portalSchedule";
	}
	
	
	//admin
	@RequestMapping("/admin/adminSchedule")
	public String adminSchedule1(){
		return "schedule/admin/adminSchedule";
	}
	
	@GetMapping("/admin/ScheduleList")
	public List<PortalScheduleVO> adminSchedule(@RequestBody PortalScheduleVO vo, Model model){
		model.addAttribute("schedules", scheduleDao.scheduleList(vo));
		return scheduleDao.scheduleList(vo);
	}
}
