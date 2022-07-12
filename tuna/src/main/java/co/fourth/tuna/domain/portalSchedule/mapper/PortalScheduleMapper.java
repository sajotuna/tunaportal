package co.fourth.tuna.domain.portalSchedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

public interface PortalScheduleMapper {
	List<PortalScheduleVO> scheduleList(@Param("key") String key);
}
