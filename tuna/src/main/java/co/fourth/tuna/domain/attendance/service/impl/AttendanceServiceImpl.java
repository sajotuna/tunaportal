package co.fourth.tuna.domain.attendance.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceUpdateFormVO;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.util.ResMsgService;
import co.fourth.tuna.util.ResMsgVO;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired AttendanceMapper map;
	
	@Autowired GradeService gradeService;
	
	@Autowired
	ResMsgService resMsgService;
	
	@Autowired
	MessageSourceAccessor msg;
	
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
	public ResMsgVO updateAttendanceList(AttendanceUpdateFormVO form) {
		ResMsgVO result = new ResMsgVO();
		
//		System.out.println(form);
		for(AttendanceVO att : form.getAttendanceList()) {
			if( !(att.getStateCode().equals("1401")||
					att.getStateCode().equals("1402")||
					att.getStateCode().equals("1403"))) {
				return new ResMsgVO(msg.getMessage("title.err.update")
						,msg.getMessage("msg.err.wrongInput"), "err");
			}
			
			if (map.updateAttendanceByAttendanceId(att) < 1) {
				return new ResMsgVO(msg.getMessage("title.err.update"),
						msg.getMessage("msg.err.fail", new String[]{"수정"}), "err");
			}
			
			if(form.getStno() == null) {
				result = gradeService.updateAttendanceTaskGrade(att.getStNo(), form.getSbjno());
			}
		}
		if(form.getStno() != null) {
			result = gradeService.updateAttendanceTaskGrade(form.getStno(), form.getSbjno());
		}
		if(result.getType().equals(ResMsgVO.SUCCESS)) {
			result = resMsgService.build(
					"title.suc.update",
					new String[] {"msg.suc.enroll", "출결"}, 
					result.getType());
		}
		
		return result;
	}

	@Override
	public List<AttendanceVO> getListByStudentIdAndSbjno(int stno, int sbjno) {
		return map.selectListByStudentIdAndSbjectId(stno, sbjno);
	}
		

}
