package co.fourth.tuna.domain.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureScheduleMapper {
	
	public List<LectureScheduleVO> findLectureScheduleForSubject(
			@Param(value="vo") SubjectVO vo);

	public List<LectureScheduleVO> findLectureScheduleForSubjectId(int sbjno);
}
