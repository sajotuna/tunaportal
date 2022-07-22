package co.fourth.tuna.domain.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.DateCheckMapper;
import co.fourth.tuna.domain.common.service.DateCheckService;

@Service
public class DateCheckServiceImpl implements DateCheckService {
	
	@Autowired
	DateCheckMapper mapper;
	
	@Override
	public int accessDateCheck(String seasonCode, String scheduleCode) {
		return mapper.accessDateCheck(seasonCode, scheduleCode);
	}

}
