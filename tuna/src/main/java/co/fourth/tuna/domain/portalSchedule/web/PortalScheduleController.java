package co.fourth.tuna.domain.portalSchedule.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.portalNotice.web.PortalNoticeController;
import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

@Controller
public class PortalScheduleController {

	private static Logger logger = LoggerFactory.getLogger(PortalNoticeController.class);

	@Autowired
	private PortalScheduleService scheduleDao;

	@Autowired
	private YearService yearService;
	
	@RequestMapping("/portalSchedule")
	public String portalSchedule() {
		return "schedule/user/portalSchedule";
	}

	// user
	@GetMapping("/portalScheduleList")
	@ResponseBody
	public List<PortalScheduleVO> portalScheduleList(PortalScheduleVO vo) {

		if(vo.getSeasonCode()==null) {
			vo.setSeasonCode(yearService.yearFind());
		}
		
		return scheduleDao.scheduleList(vo);
	}
	

	// admin
	@RequestMapping("/admin/adminSchedule")
	public String adminSchedule() {
		return "schedule/admin/adminSchedule";
	}
	

	@GetMapping("/admin/adminScheduleList")
	@ResponseBody
	public List<PortalScheduleVO> adminScheduleList(PortalScheduleVO vo) {

		List<PortalScheduleVO> list = scheduleDao.adminScheduleList(vo);

		return list;
	}

	@PostMapping("/admin/adminScheduleInsert")
	@ResponseBody
	public int scheduleInsert(@RequestBody PortalScheduleVO vo, Authentication authentication) {		
		vo.setAdNo((authentication.getName()));
		logger.info("insert::" + vo);
		
		return scheduleDao.scheduleInsert(vo);
	}
	
	@DeleteMapping("/admin/adminSchduleDelete")
	@ResponseBody
	public int schduleDelete(@RequestBody PortalScheduleVO vo) {
		logger.info("delete::" + vo);
		return scheduleDao.scheduleDelete(vo);
	}
 
}
