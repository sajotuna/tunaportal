package co.fourth.tuna.domain.lectureplan.mapper;


import java.util.List;

import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;

public interface LecturePlanMapper {

	public LecturePlanVO selectPlan(LecturePlanVO vo);
	
	public LecturePlanVO selectSc(LecturePlanVO vo);
	
	public List<LecturePlanVO> findListBySubjectId(int sbjno);
}
