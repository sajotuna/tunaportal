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
		
	//admin
	public int scheduleInsert(PortalScheduleVO vo) {
		return map.scheduleInsert(vo);
	}
	

	public int scheduleDelete(PortalScheduleVO vo) {
		return map.scheduleDelete(vo);
	}
	
	@Override
	public List<PortalScheduleVO> adminScheduleList(PortalScheduleVO vo) {
		return map.adminScheduleList(vo);
	}


	@Override
	public PortalScheduleVO findSeasonSchedule(String season, String schedule) {
		return map.findOneBySeasonCode(season, schedule);
	}

	@Override
	public PortalScheduleVO findTuitionSchedule(PortalScheduleVO vo) {
		return map.findTuitionSchedule(vo);
	}
	

}

