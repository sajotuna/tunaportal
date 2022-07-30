package co.fourth.tuna.domain.attendance.service;

import java.time.LocalDate;
import java.util.List;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;

public interface AttendanceService {

	//단일과목 출석 조회
	public String studentAttendance(AttendanceVO vo);
	
	// 가장 가까운 수업일
	public LocalDate findThisAttendanceBySubjectId(int sbjno);
	// 해당 날짜 출결 출석부
	public List<AttendanceVO> findAttendanceByDateAndSubjectId(LocalDate date, int sbjno);
	
	// 출석부 업데이트
	public String updateAttendanceList(List<AttendanceVO> list);
	
	// 
	public List<AttendanceVO> getListByStudentIdAndSbjno(int stno, int sbjno);
	
}
