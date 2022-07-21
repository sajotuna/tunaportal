package co.fourth.tuna.domain.portalSchedule.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

public interface PortalScheduleService {
	///user
	List<PortalScheduleVO> scheduleList(PortalScheduleVO vo);
	
	List<PortalScheduleVO> scheduleSearch(@Param("key")String key);
	
	//admin
	int scheduleInsert(PortalScheduleVO vo);

	PortalScheduleVO findSeasonSchedule(String season, String schedule);

	int scheduleDelete(PortalScheduleVO vo);
	
	List<PortalScheduleVO> adminScheduleList(PortalScheduleVO vo);
	public PortalScheduleVO findTuitionSchedule(PortalScheduleVO vo);
}
