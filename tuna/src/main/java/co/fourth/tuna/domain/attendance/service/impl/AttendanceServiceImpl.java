package co.fourth.tuna.domain.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;

public class AttendanceServiceImpl implements AttendanceService {

	@Autowired AttendanceMapper map;
	
	@Override
	public String studentAttendance(AttendanceVO vo) {
		return map.studentAttendance(vo);
	}

}
