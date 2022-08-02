package co.fourth.tuna.domain.subject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.subject.vo.SubjectWithAttendanceVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

public interface SubjectMapper {
	public SubjectVO findOne(SubjectVO vo);
	public SubjectVO findOneById(int no);
	public SubjectVO findOneWithApplysAndRatioAndFilesById(int no);
	
	public List<SubjectVO> findListByProfessorVO(
			@Param("prof")ProfessorVO vo, 
			@Param("seasonCode")int seasonCode);
	
	public ArrayList<SubjectVO> findListForProfessorMain(
			@Param("prof") ProfessorVO vo, 
			@Param("seasonCode")int code,
			@Param("pageNum")int pageNum,
			@Param("size")int size );
	public List<SubjectVO> SubjectCheck();

	public List<SubjectVO> searchSubjectList(@Param("seasonCode") String seasonCode, 
											 @Param("searchKey") String searchKey, 
											 @Param("key") String key);

	public List<SubjectVO> findSbjByStud(@Param("stud") StudentVO vo, @Param("seasonCode") int code);
	public List<SubjectVO> selectOneSubTask(@Param("stud") StudentVO vo, @Param("sbj") SubjectVO sbjvo);

	public List<SubjectWithAttendanceVO> selectListByStudentIdAndPrfessorId(
			@Param("stno")int stno, 
			@Param("pfno")int pfno,
			@Param("season")String season);

	
	public int subjectCount(String seasonCode);
	

	//public ArrayList<SubjectVO>findListForLectureSchedule(@Param("pageNum")int start, @Param("size")int size);
	//public ArrayList<Map<String, Object>>findListForLectureScheduleByProf(@Param("prof")ProfessorVO prof, @Param("pageNum")int pageNum, @Param("size")int size);
	
}
