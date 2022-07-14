package co.fourth.tuna.domain.lectureplan.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;

@Service
public class LecturePlanServiceImpl implements LecturePlanService{
	
	@Autowired
	LecturePlanMapper mapper;

	@Override
	public LecturePlanVO selectPlan(LecturePlanVO vo) {
		return mapper.selectPlan(vo);
	}


	
	
}
