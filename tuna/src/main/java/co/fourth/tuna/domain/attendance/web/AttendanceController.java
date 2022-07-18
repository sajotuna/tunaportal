package co.fourth.tuna.domain.attendance.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;

@Controller
public class AttendanceController {

	@Autowired
	SqlSession sql;

	@RequestMapping("/eclass/student/attendance")
	public String studentAttendance(Model model, AttendanceVO vo) {
		vo.setStNo(13168019);
		vo.setSbjNo(18011);
		
		List<Map<String, Object>> attd = sql.selectList("co.fourth.tuna.domain.attendance.mapper.AttendanceMapper.studentAttendance", vo);
		
		model.addAttribute("attd", attd);
		
		System.out.println(attd);
		
		return "eclass/stud/attendance";
	}
}
