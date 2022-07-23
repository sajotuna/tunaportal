package co.fourth.tuna.domain.lectureplan.service;

import java.util.List;

import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.util.ServiceResponseVO;

public interface LecturePlanService {

	//단일과목 강의계획 조회
	public LecturePlanVO selectPlan(LecturePlanVO vo);
	
	//단일과목 강의스케쥴 조회
	public LecturePlanVO selectSc(LecturePlanVO vo);
	
	public List<LecturePlanVO> findListBySubjectId(int sbjno);
	
	public ServiceResponseVO updatePlanList(List<LecturePlanVO> planList);
}
