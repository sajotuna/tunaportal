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
	public List<PortalScheduleVO> scheduleList(PortalScheduleVO vo) {
		return map.scheduleList(vo);
	}
	
	public int scheduleInsert(PortalScheduleVO vo) {
		return map.scheduleInsert(vo);
	}

	@Override
	public PortalScheduleVO findSeasonSchedule(String season, String schedule) {
		return map.findOneBySeasonCode(season, schedule);
	}
	
	
	
}

