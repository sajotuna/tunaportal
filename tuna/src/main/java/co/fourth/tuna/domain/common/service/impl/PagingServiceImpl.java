package co.fourth.tuna.domain.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.PagingMapper;
import co.fourth.tuna.domain.common.service.PagingService;
import co.fourth.tuna.domain.common.vo.PagingVO;

@Service
public class PagingServiceImpl implements PagingService {
	
	@Autowired
	PagingMapper map;
	
	@Override
	public PagingVO getPaging(PagingVO vo) {
		return map.getPaging(vo);
	}

}
