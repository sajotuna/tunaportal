package co.fourth.tuna.domain.common.service;

import java.util.List;
import java.util.Map;

public interface UniMapperService {
	
	public List<Object> findByTable(String tableName, Object obj);
}
