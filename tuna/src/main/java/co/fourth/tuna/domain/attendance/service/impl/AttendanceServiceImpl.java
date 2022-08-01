package co.fourth.tuna.domain.attendance.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceUpdateFormVO;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.service.GradeService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired AttendanceMapper map;
	
	@Autowired GradeService gradeService;
	
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
	public String updateAttendanceList(AttendanceUpdateFormVO form) throws Error{
		String result = "";
		System.out.println(form);
		for(AttendanceVO att : form.getAttendanceList()) {
			System.out.println(att);
			if( !(att.getStateCode().equals("1401")||
					att.getStateCode().equals("1402")||
					att.getStateCode().equals("1403"))) {
				throw new Error("잘못된 입력 입니다.");
			}
			
			if (map.updateAttendanceByAttendanceId(att) < 1) {
				throw new Error("업데이트 실패");
			}
			
			if(form.getStno() == null) {
				gradeService.updateAttendanceTaskGrade(att.getStNo(), form.getSbjno());
			}
		}
		if(form.getStno() != null) {
			result = gradeService.updateAttendanceTaskGrade(form.getStno(), form.getSbjno());
		}
		
		return result;
	}

	@Override
	public List<AttendanceVO> getListByStudentIdAndSbjno(int stno, int sbjno) {
		return map.selectListByStudentIdAndSbjectId(stno, sbjno);
	}
		

}
