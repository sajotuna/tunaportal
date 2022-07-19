package co.fourth.tuna.domain.attendance.service;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;

public interface AttendanceService {

	//단일과목 출석 조회
	public String studentAttendance(AttendanceVO vo);
	
}
