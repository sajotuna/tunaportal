package co.fourth.tuna.domain.attendance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface AttendanceMapper {
	
	public List<AttendanceVO> selectAttendancesForSubject(SubjectVO subject);
	public List<AttendanceVO> findListByStudentIdAndSubjectId(
			@Param(value="stno") int stno, 
			@Param(value="sbjno") int sbjno);
	
	//단일과목 출석 조회
	public String studentAttendance(AttendanceVO vo);
}
