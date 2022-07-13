package co.fourth.tuna.domain.portalSchedule.service;

import java.util.List;

import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

public interface PortalScheduleService {
	List<PortalScheduleVO> scheduleList(PortalScheduleVO vo);

	
}
