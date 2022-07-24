package co.fourth.tuna.domain.lectureplan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.util.ResState;
import co.fourth.tuna.util.ServiceResponseVO;

@Service
public class LecturePlanServiceImpl implements LecturePlanService{
	
	@Autowired
	LecturePlanMapper mapper;

	@Override
	public LecturePlanVO selectPlan(LecturePlanVO vo) {
		return mapper.selectPlan(vo);
	}

	@Override
	public LecturePlanVO selectSc(LecturePlanVO vo) {
		return mapper.selectSc(vo);
	}

	@Override
	public List<LecturePlanVO> findListBySubjectId(int sbjno) {
		return mapper.findListBySubjectId(sbjno);
	}

	@Override
	@Transactional
	public String updatePlanList(List<LecturePlanVO> planList) {
		List<LecturePlanVO> list = planList;
		for(LecturePlanVO plan : list) {			
			if(mapper.updateOneByNo(plan) < 1) {
				throw new Error("업데이트 도중 오류 발생");
			}
			
		}
		
		return "성공";
	}


	
	
}
