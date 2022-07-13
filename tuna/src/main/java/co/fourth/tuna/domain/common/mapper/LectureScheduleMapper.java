package co.fourth.tuna.domain.common.mapper;

import java.util.ArrayList;

import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureScheduleMapper {
	
	public ArrayList<LectureScheduleVO> findLectureScheduleForSubject(SubjectVO vo);
}
