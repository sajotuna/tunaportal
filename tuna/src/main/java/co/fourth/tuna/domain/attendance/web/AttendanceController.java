package co.fourth.tuna.domain.attendance.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceUpdateFormVO;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentWithAttendanceVO;
import co.fourth.tuna.util.ResMsgVO;
import co.fourth.tuna.web.eclass.professor.vo.SubjectAttendanceRestVO;

@Controller
public class AttendanceController {

	@Autowired
	SqlSession sql;
	
	@Autowired
	AttendanceService service;
	@Autowired
	StudentService studentService;
	
	@ResponseBody
	@PostMapping("/staff/attendance")
	public SubjectAttendanceRestVO getAttendance(
			@RequestBody Map<String, Integer> reqData) {
		int sbjno = -1;
		if( reqData.get("sbjno") != null ) {
			sbjno = reqData.get("sbjno");
		} else {
			return null;
		}
		 
		LocalDate closetDate = service.findThisAttendanceBySubjectId(sbjno);
		List<StudentWithAttendanceVO> students = studentService.findStudentWithAttendanceListBySubjectIdAndDate(sbjno, closetDate);
		SubjectAttendanceRestVO result = new SubjectAttendanceRestVO(students, closetDate);
		return result;
	}
	
	@PostMapping("/staff/insert/attendance")
	public ResponseEntity<ResMsgVO> submitsAttendance(
			Authentication auth,
			@RequestBody AttendanceUpdateFormVO form) {
		
		// TODO sbjno 가 내강의인지 체크하기
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<ResMsgVO> res = null;
		
		ResMsgVO msg = service.updateAttendanceList(form);
		
		res = new ResponseEntity<ResMsgVO>(
				msg,
				resHeaders,
				HttpStatus.OK);
		
		return res;
	}
	
	@PostMapping("/staff/update/attendance")
	public ResponseEntity<ResMsgVO> updateAttendance(
			@RequestBody AttendanceUpdateFormVO form) {
		// TODO sbjno 가 내 강의인지 체크하기

		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<ResMsgVO> res = null;
		
		ResMsgVO msg = service.updateAttendanceList(form);
		
		res = new ResponseEntity<ResMsgVO>(
				msg,
				resHeaders,
				HttpStatus.OK);
		
		return res;
	}
	
//	@RequestMapping("/eclass/student/attendance")
//	public String studentAttendance(Model model, AttendanceVO vo) {
//		vo.setStNo(13168019);
//		vo.setSbjNo(18011);
//		
//		List<Map<String, Object>> attd = sql.selectList("co.fourth.tuna.domain.attendance.mapper.AttendanceMapper.studentAttendance", vo);
//
//		int[] i = new int[16];
//		
//		model.addAttribute("i", i);
//		model.addAttribute("attd", attd);
//		
//		System.out.println(i);
//		
//		
//		return "eclass/stud/attendance";
//	}
}
