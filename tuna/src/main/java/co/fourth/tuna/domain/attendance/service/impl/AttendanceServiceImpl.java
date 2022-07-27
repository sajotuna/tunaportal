package co.fourth.tuna.domain.attendance.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired AttendanceMapper map;
	
	@Override
	public String studentAttendance(AttendanceVO vo) {
		return map.studentAttendance(vo);
	}

	@Override
	public LocalDate findThisAttendanceBySubjectId(int sbjno) {
		LocalDate date = map.selectThisAttendanceBySubjectId(sbjno).toLocalDate();
		return date;
	}

	@Override
	public List<AttendanceVO> findAttendanceByDateAndSubjectId(LocalDate date, int sbjno) {
		return map.findAttendanceByDateAndSubjectId(date, sbjno);
	}

}
