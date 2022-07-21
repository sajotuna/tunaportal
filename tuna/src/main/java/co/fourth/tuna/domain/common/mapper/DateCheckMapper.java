package co.fourth.tuna.domain.common.mapper;

import org.apache.ibatis.annotations.Param;

public interface DateCheckMapper {
	
	public int accessDateCheck(@Param("seasonCode")String seasonCode, 
			                   @Param("scheduleCode")String scheduleCode);

}
