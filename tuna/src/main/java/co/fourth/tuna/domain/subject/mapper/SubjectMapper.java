package co.fourth.tuna.domain.subject.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface SubjectMapper {
	public ArrayList<SubjectVO>findListForLectureSchedule(@Param("pageNum")int start, @Param("size")int size);
	public ArrayList<SubjectVO>findListForLectureScheduleByProf(@Param("prof")ProfessorVO prof, @Param("pageNum")int pageNum, @Param("size")int size);
	
	public SubjectVO findOne();
	
}
