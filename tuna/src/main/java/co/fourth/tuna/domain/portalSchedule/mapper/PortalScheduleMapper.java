package co.fourth.tuna.domain.portalSchedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

public interface PortalScheduleMapper {
	// user
	List<PortalScheduleVO> scheduleList(PortalScheduleVO vo);
	
	// admin
	int scheduleInsert(PortalScheduleVO vo);

	int scheduleDelete(PortalScheduleVO vo);

	List<PortalScheduleVO> adminScheduleList(PortalScheduleVO vo);

	PortalScheduleVO findOneBySeasonCode(@Param(value = "seasonCode") String seasonCode,
			@Param(value = "scheduleCode") String scheduleCode);

}
