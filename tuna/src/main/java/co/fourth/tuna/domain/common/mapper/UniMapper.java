package co.fourth.tuna.domain.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UniMapper {
	
	public List<Map> findByTableName(@Param("tableName")String tableName);
}
