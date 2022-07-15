package co.fourth.tuna.domain.lectureplan.service;

import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;

public interface LecturePlanService {

	//단일과목 강의계획 조회
	public LecturePlanVO selectPlan(LecturePlanVO vo);
	
	//단일과목 강의스케쥴 조회
	public LecturePlanVO selectSc(LecturePlanVO vo);
}