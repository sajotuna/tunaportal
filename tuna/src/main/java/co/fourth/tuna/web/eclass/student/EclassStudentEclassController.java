package co.fourth.tuna.web.eclass.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.web.eclass.EclassController;
import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

@Controller
@RequestMapping("/eclass/student")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
	
	
//	//출석
//	@RequestMapping("/attendance")
//	public String attendance() {
//		return "eclass/stud/attendance";
//	}
	
	//자료실
	@RequestMapping("/download") 
	public String download() {
		return "eclass/stud/download";
	}
	
	//수강목록 홈
	@Autowired private SubjectMapper map;
	@Autowired private SqlSession sql;
	@RequestMapping("/home")
	public String home(Model model, EclassStudentHomeVO vo) {
		vo.setNo(13168019);
		vo.setSeasonCode(106);
		List<Map<String, Object>> list = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
		model.addAttribute("list", list);
		
		
		
		List<Map<String, Object>> tt = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.twoTask", vo);
		System.out.println(tt);
		model.addAttribute("tt", tt);
		
		return "eclass/stud/home";
	}
	
//	//강의공지
//	@RequestMapping("/lectureNotice")
//	public String lectureNotie() {
//		return "eclass/stud/lectureNotice";
//	}
	
	//단건강의홈
	@RequestMapping("/lectureHome")
	public String lectureHome() {
		return "eclass/stud/lectureHome";
	}
	
//	//공지사항조회
//	@RequestMapping("/lectureNoticeSelect")
//	public String lectureNoticeSelect() {
//		return "eclass/stud/lectureNoticeSelect";
//	}
	
	//강의계획서
//	@RequestMapping("/lecturePlan")
//	public String lecturePlan() {
//		return "eclass/stud/lecturePlan";
//	}
	
//	//질의응답보기
//	@RequestMapping("/qnaForm")
//	public String qnaForm() {
//		return "eclass/stud/qnaForm";
//	}
	
	//질의응답작성
	@RequestMapping("/qnaInsert")
	public String qnaInsert() {
		return "eclass/stud/qnaInsert";
	}
	
//	//질의응답목록
//	@RequestMapping("/qnaList")
//	public String qnaList() {
//		return "eclass/stud/qnaList";
//	}
	
//	//과제
//	@RequestMapping("/taskList")
//	public String taskList() {
//		return "eclass/stud/taskList";
//	}
	
//	//과제보기
//	@RequestMapping("/taskSelect")
//	public String taskSelect() {
//		return "eclass/stud/taskSelect";
//	}
	
}
