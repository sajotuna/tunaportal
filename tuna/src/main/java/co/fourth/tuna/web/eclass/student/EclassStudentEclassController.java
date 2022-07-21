package co.fourth.tuna.web.eclass.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.web.eclass.EclassController;
import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

@Controller
@RequestMapping("/eclass/student")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	@Autowired SqlSession sql;
	@Autowired LectureNoticeService service;
	@Autowired TaskService taskDao;
	@Autowired private FileService fileService;
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
	
	
	@RequestMapping("/lectureNotice")
	public String lectureNotice(Model model, LectureNoticeVO vo) {
		vo.setSbjNo(90079);
		vo.setSeasonCode(105);
		vo.setStNo(13168019);
		List<Map<String, Object>> notice = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeList", vo);
		
		model.addAttribute("notice", notice);
		
		return "eclass/stud/lectureNotice";
	}
	
	@RequestMapping("/lectureNoticeSelect")
	public String lectureNoticeSelect(Model model, LectureNoticeVO vo) {
		
		vo.setStNo(13168019);
		vo.setSeasonCode(105);
		vo.setSbjNo(90079);
		vo.setNo(1);
		List<Map<String, Object>> ns = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeSelect", vo);
		
		
		model.addAttribute("ns", ns);
		
		return "eclass/stud/lectureNoticeSelect";
	}
	
	@RequestMapping("/lecturePlan")
	public String lecturePlan(Model model, LecturePlanVO vo) {
		vo.setSbjNo(18101);
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		//강의스케쥴
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[11].split("~");
		
		model.addAttribute("sc", lectureSchedule.get(0));
		model.addAttribute("plan", lists.get(0));
		model.addAttribute("weekplan", weekplan);
		return "eclass/stud/lecturePlan";
	}
	
	@RequestMapping("/qnaList")
	public String qnaList(Model model, @RequestParam HashMap<String, Object> map, @RequestParam(value="pageNum", required=false, defaultValue= "1" ) int pageNum) {
		
		map.put("sbjNo", 18011);
		map.put("pageNum", pageNum);
		map.put("size", 5);
		List<Map<String, Object>> qna = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", map);
		
		map.put("sbjNo", 18011);
		map.put("pageNum", pageNum);
		map.put("size", 100);
		List<Map<String, Object>> qna2 = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", map);
		
		int pageCount = (int)Math.ceil((double)qna2.size()/(5));
		
		model.addAttribute("qna", qna);
		model.addAttribute("pgcnt", pageCount);
		
		
		return "eclass/stud/qnaList";
	}
	
	@RequestMapping("/qnaSelect")
	public String qnaSelect(Model model, LectureQnaVO vo) {
		
		vo.setNo(1);
		vo.setSbjNo(18011);
		vo.setStNo(13168019);
		List<Map<String, Object>> qs = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaSelect", vo);
		
		model.addAttribute("qs", qs);
		
		return "eclass/stud/qnaSelect";
	}
	
	@RequestMapping("/taskList")
	public String taskList(Model model) {
		
		//단일과목과제 조회
		StudentVO sv = new StudentVO();
		SubjectVO sb = new SubjectVO();
		sv.setNo(13168019);
		sb.setNo(90079);
		List<SubjectVO> sbjli = map.selectOneSubTask(sv, sb);
		model.addAttribute("sbjli", sbjli);
		return "eclass/stud/taskList";
	}
	
	@RequestMapping("/taskSelect")
	public String taskSelect(Model model, TaskVO vo, Authentication authentication){
		vo.setNo(1);
		vo.setSbjNo(90079);
		
		SubmitTaskVO vo1 = new SubmitTaskVO();
		//로그인한 유저 아이디
		vo1.setStNo(Integer.parseInt(authentication.getName()));
		//과제인덱스
		vo1.setTaskNo(vo.getNo());
		
		List<Map<String, Object>> tsk = sql.selectList("co.fourth.tuna.domain.task.mapper.TaskMapper.taskSelect", vo);
		System.out.println("12354574679");
		List<SubmitTaskVO> fts = new ArrayList<>();
		if(taskDao.findSubmission(vo1).size() != 0) {
			fts = taskDao.findSubmission(vo1);
		}
		
		model.addAttribute("tsk", tsk);
		model.addAttribute("fts",fts);
		
		return "eclass/stud/taskSelect";
	}
	
	//과제 등록
	@RequestMapping("/taskInsert")
	public String taskSubmission(TaskVO vo, Authentication authentication,
			@RequestParam(value = "file") MultipartFile[] files) throws IOException {
		
		vo.setNo(1);
		vo.setSbjNo(90079);
		
		SubmitTaskVO vo1 = new SubmitTaskVO();
		
		for(MultipartFile file : files) {
			String ogn = file.getOriginalFilename();
			
			if(ogn != null && ogn.length() != 0) {
				String[] tf = fileService.upload(file, "task");
				
				vo1.setFileName(tf[0]);
				vo1.setUri(tf[1]);
				vo1.setStNo(Integer.parseInt(authentication.getName()));
				vo1.setTaskNo(vo.getNo());
				
				taskDao.taskSubmission(vo1);
			}
		}
		
		return "redirect:/eclass/student/taskSelect";
	}
	
	@DeleteMapping("/deleteSubmitTask")
	@ResponseBody
	public void deleteSubmitTask(@RequestBody SubmitTaskVO vo) {
		fileService.delete(vo.getUri(), "task");
		taskDao.deleteSubmitTask(vo);
		
	}
	

	//자료실
	@RequestMapping("/download") 
	public String download() {
		return "eclass/stud/download";
	}
	
	//수강목록 홈
	@Autowired private SubjectMapper map;
	@RequestMapping("/home")
	public String home(Model model, EclassStudentHomeVO vo) {
		vo.setNo(13168019);
		vo.setSeasonCode(106);
		List<Map<String, Object>> list = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
		model.addAttribute("list", list);
		
		
		
		List<Map<String, Object>> tt = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.twoTask", vo);
		model.addAttribute("tt", tt);
		
		return "eclass/stud/home";
	}
	
	//단건강의홈
	@RequestMapping("/lectureHome")
	public String lectureHome(Model model, EclassStudentHomeVO vo) {
		vo.setSeasonCode(106);
		vo.setSbjNo(18011);
		
		List<Map<String, Object>> stn = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.singleTwoNotice", vo);
		List<Map<String, Object>> stt = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.singleTwoTask", vo);
		List<Map<String, Object>> stq = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.singleTwoQna", vo);
		List<Map<String, Object>> stf = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.singleTwoFile", vo);
		
		model.addAttribute("stn", stn);
		
		model.addAttribute("stt", stt);
		model.addAttribute("stq", stq);
		model.addAttribute("stf", stf);
		
		return "eclass/stud/lectureHome";
	}
	
	//질의응답작성
	@RequestMapping("/qnaInsert")
	public String qnaInsert() {
		return "eclass/stud/qnaInsert";
	}

	//출석
	@RequestMapping("/attendance")
	public String studentAttendance(Model model, AttendanceVO vo) {
		vo.setStNo(13168019);
		vo.setSbjNo(18011);
		
		List<Map<String, Object>> attd = sql.selectList("co.fourth.tuna.domain.attendance.mapper.AttendanceMapper.studentAttendance", vo);
		
		model.addAttribute("attd", attd);
		
		
		return "eclass/stud/attendance";
	}
	//사이드바 작업 열심히 해보자
	@ModelAttribute("side")
	public Map<String, Object> side() {
		
		EclassStudentHomeVO vo = new EclassStudentHomeVO();
		
		vo.setNo(13168019);
		vo.setSeasonCode(106);
		
		Map<String, Object> sidemap = new HashMap<String, Object>();
		List<Map<String, Object>> list = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
		sidemap.put("side", list);
		
		return sidemap;
	}
}
