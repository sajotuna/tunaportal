package co.fourth.tuna.domain.tuition.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.tuition.mapper.TuitionMapper;
import co.fourth.tuna.domain.tuition.service.TuitionService;
import co.fourth.tuna.domain.tuition.vo.tuitionGiveVO;

@Service
public class TuitionServiceImpl implements TuitionService {

	@Autowired
	private TuitionMapper map;
	
	
	@Override
	public tuitionGiveVO tuitionCheck(tuitionGiveVO vo) {
		// TODO Auto-generated method stub
		return map.tuitionCheck(vo);
	}

}
