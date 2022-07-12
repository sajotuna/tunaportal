package co.fourth.tuna.web.eclass.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.web.eclass.EclassController;

@Controller
@RequestMapping("/eclass/student")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
	
	
	//출석
	@RequestMapping("/attendance")
	public String attendance() {
		return "eclass/stud/attendance";
	}
	
	//자료실
	@RequestMapping("/download") 
	public String download() {
		return "eclass/stud/download";
	}
	
	//수강목록 홈
	@RequestMapping("/home")
	public String home() {
		return "eclass/stud/home";
	}
	
	//강의공지
	@RequestMapping("/lectureNotice")
	public String lectureNotie() {
		return "eclass/stud/lectureNotice";
	}
	
	//단건강의홈
	@RequestMapping("/lectureHome")
	public String lectureHome() {
		return "eclass/stud/lectureHome";
	}
	
	//공지사항조회
	@RequestMapping("/lectureNoticeSelect")
	public String lectureNoticeSelect() {
		return "eclass/stud/lectureNoticeSelect";
	}
	
	//강의계획서
	@RequestMapping("/lecturePlan")
	public String lecturePlan() {
		return "eclass/stud/lecturePlan";
	}
	
	//질의응답보기
	@RequestMapping("/qnaForm")
	public String qnaForm() {
		return "eclass/stud/qnaForm";
	}
	
	//질의응답작성
	@RequestMapping("/qnaInsert")
	public String qnaInsert() {
		return "eclass/stud/qnaInsert";
	}
	
	//질의응답목록
	@RequestMapping("/qnaList")
	public String qnaList() {
		return "eclass/stud/qnaList";
	}
	
	//과제
	@RequestMapping("/taskList")
	public String taskList() {
		return "eclass/stud/taskList";
	}
	
	//과제보기
	@RequestMapping("/taskSelect")
	public String taskSelect() {
		return "eclass/stud/taskSelect";
	}
	
}
