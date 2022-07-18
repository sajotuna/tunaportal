package co.fourth.tuna.domain.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.YearMapper;
import co.fourth.tuna.domain.common.service.YearService;

@Service
public class YearServiceImpl implements YearService {
	@Autowired
	private YearMapper mapper;
	
	
	@Override
	public String yearFind() {
		return mapper.yearFind();
	}

}
