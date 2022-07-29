package co.fourth.tuna.domain.attendance.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public String updateAttendanceList(List<AttendanceVO> list) throws Error{
		for(AttendanceVO att : list) {
			// TODO 출결 코드로 바꾸기
			if( !(att.getStateCode().equals("1401")||
					att.getStateCode().equals("1402")||
					att.getStateCode().equals("1403"))) {
				throw new Error("잘못된 입력 입니다.");
			}
			
			if (map.updateAttendanceByAttendanceId(att) < 1) {
				throw new Error("업데이트 실패");
			}
			
		}
		return "업데이트 성공";
	}

	@Override
	public List<AttendanceVO> getListByStudentIdAndSbjno(int stno, int sbjno) {
		return map.selectListByStudentIdAndSbjectId(stno, sbjno);
	}

}
