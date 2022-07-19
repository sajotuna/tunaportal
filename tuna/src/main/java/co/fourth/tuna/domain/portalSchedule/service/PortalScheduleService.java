package co.fourth.tuna.domain.portalSchedule.service;

import java.util.List;

import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

public interface PortalScheduleService {
	///user
	List<PortalScheduleVO> scheduleList(PortalScheduleVO vo);
	
	//admin
	int scheduleInsert(PortalScheduleVO vo);
	
	PortalScheduleVO findSeasonSchedule(String season, String schedule);
}
