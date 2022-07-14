package co.fourth.tuna.domain.attendance.mapper;

import java.util.List;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface AttendanceMapper {
	
	public List<AttendanceVO> selectAttendancesForSubject(SubjectVO subject);
}
