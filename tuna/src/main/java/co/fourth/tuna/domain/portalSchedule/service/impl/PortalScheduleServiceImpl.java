package co.fourth.tuna.domain.portalSchedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.fourth.tuna.domain.portalSchedule.mapper.PortalScheduleMapper;
import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

@Repository("ScheduleDao")
public class PortalScheduleServiceImpl implements PortalScheduleService {

	@Autowired
	private PortalScheduleMapper map;
	
	@Override
	public List<PortalScheduleVO> scheduleList(String key){
		return null;
	}
	
}
