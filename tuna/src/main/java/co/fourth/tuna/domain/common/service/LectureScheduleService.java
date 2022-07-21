package co.fourth.tuna.domain.common.service;

import java.util.List;

import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;

public interface LectureScheduleService {
	public List<LectureScheduleVO> findScheduleBySubjectId(int sbjno);
}
