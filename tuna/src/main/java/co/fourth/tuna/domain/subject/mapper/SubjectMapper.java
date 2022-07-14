package co.fourth.tuna.domain.subject.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface SubjectMapper {
	public SubjectVO findOne(SubjectVO vo);
	public ArrayList<SubjectVO> findListForProfessorMain(
			@Param("prof") ProfessorVO vo, 
			@Param("seasonCode")int code,
			@Param("pageNum")int pageNum,
			@Param("size")int size );
	public List<SubjectVO> SubjectCheck();
	
	//public ArrayList<SubjectVO>findListForLectureSchedule(@Param("pageNum")int start, @Param("size")int size);
	//public ArrayList<Map<String, Object>>findListForLectureScheduleByProf(@Param("prof")ProfessorVO prof, @Param("pageNum")int pageNum, @Param("size")int size);
	
}
