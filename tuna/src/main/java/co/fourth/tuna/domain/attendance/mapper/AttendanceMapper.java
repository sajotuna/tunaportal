package co.fourth.tuna.domain.attendance.mapper;

import java.sql.Date;
import java.time.LocalDate;
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
	// 가장 가까운 출결 가져오기
	// TODO sysdate 바꿀건가요??
	public Date selectThisAttendanceBySubjectId(int sbjno);
	
	// 해당 날짜 출결 가져오기
	public List<AttendanceVO> findAttendanceByDateAndSubjectId(LocalDate date, int sbjno);
	// 해당 날짜 학생 출결 가져오기
	public AttendanceVO findAttendanceByDateAndSubjectIdAndStudentId(
			@Param("date")LocalDate date, 
			@Param("sbjno")int sbjno, 
			@Param("stno")int stno);
}
