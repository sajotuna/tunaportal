package co.fourth.tuna.web.eclass.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
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
@RequestMapping("/stud/eclass")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	@Autowired SqlSession sql;
	@Autowired LectureNoticeService service;
	@Autowired TaskService taskDao;
	@Autowired LectureFileService fileDao;
	@Autowired LectureQnaService qnaDao;
	@Autowired private FileService fileService;
	@Autowired YearService year;
	@Autowired String fileDir;
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
	
	
	@RequestMapping("/lectureNotice")
	public String lectureNotice(Model model, LectureNoticeVO vo, HttpServletRequest req,  Authentication authentication) {
//		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo")));
		vo.getSbjNo();
		vo.setStNo(Integer.parseInt(authentication.getName()));
		List<Map<String, Object>> notice = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeList", vo);
		
		model.addAttribute("notice", notice);
		
		return "eclass/stud/lectureNotice";
	}
	
	@RequestMapping("/lectureNoticeSelect")
	public String lectureNoticeSelect(Model model, LectureNoticeVO vo, HttpServletRequest req, Authentication authentication) {
		
		vo.setStNo(Integer.parseInt(authentication.getName()));
		vo.getSbjNo();
		vo.setNo(Integer.parseInt(req.getParameter("no")));
		List<Map<String, Object>> ns = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeSelect", vo);
		
		
		model.addAttribute("ns", ns);
		
		return "eclass/stud/lectureNoticeSelect";
	}
	
	@RequestMapping("/lecturePlan")
	public String lecturePlan(Model model, HttpServletRequest req, LecturePlanVO vo) {
		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo")));
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		//???????????????
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[11].split("~");
		
		
		model.addAttribute("sc", lectureSchedule.get(0));
		model.addAttribute("plan", lists.get(0));
		model.addAttribute("weekplan", weekplan);
		return "eclass/stud/lecturePlan";
	}
	
	@RequestMapping("/qnaList")
	public String qnaList(Model model, LectureQnaVO vo, HttpServletRequest req,
			@RequestParam HashMap<String, Object> map, 
			@RequestParam(value="pageNum", required=false, defaultValue= "1" ) int pageNum) {
		
		map.put("sbjNo", vo.getSbjNo());
		map.put("pageNum", pageNum);
		map.put("size", 10);
		map.put("listSize", Math.ceil((double)qnaDao.lectureQnaPagingCount(vo)/10));
		List<Map<String, Object>> qna = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", map);
		int length = qna.size();
		
		model.addAttribute("qna", qna);
		model.addAttribute("map", map);
		model.addAttribute("sbjNo", vo.getSbjNo());
		model.addAttribute("length", length);
		
		return "eclass/stud/qnaList";
	}
	
	@RequestMapping("/qnaSelect")
	public String qnaSelect(Model model, LectureQnaVO vo, HttpServletRequest req, Authentication authentication) {
		;
		//????????? ???????????? vo??? setting
//		vo.setNo(Integer.parseInt(req.getParameter("no")));
		vo.getVisible();
		
		List<Map<String, Object>> qs = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaSelect", vo);
		model.addAttribute("qs", qs);
		model.addAttribute("sbjNo", vo.getSbjNo());
		model.addAttribute("no", vo.getNo());
		
		return "eclass/stud/qnaSelect";
	}
	
	//?????????????????????
	@RequestMapping("/qnaInsert")
	public String qnaInsert(Model model, LectureQnaVO vo, RedirectAttributes redir,
							HttpServletRequest req,
							Authentication authentication) {
		model.addAttribute("sbjNo",req.getParameter("sbjNo"));
		
		return "eclass/stud/qnaInsert";
	}
	
	//??????????????????
	@RequestMapping("/insertOneQna")
	public String insertOneQna(Model model, LectureQnaVO vo, RedirectAttributes redir,
			HttpServletRequest req, Authentication authentication) {
		
		vo.setStNo(Integer.parseInt(authentication.getName()));
		vo.setVisible(Integer.parseInt(req.getParameter("visibleCheck")));

		
		qnaDao.insertOneQna(vo);
		
		redir.addFlashAttribute("question", "?????? ????????????????????????? ??????????????? ?????? ??? ????????? ??????????????????.");
		redir.addAttribute("no", vo.getNo());
		redir.addAttribute("sbjNo", vo.getSbjNo());
		
		return "redirect:/stud/eclass/qnaSelect";
	}
	
	/*
	 * @RequestMapping("/delOneQna") public String delOneQna(LectureQnaVO vo,
	 * RedirectAttributes redir,Authentication authentication) {
	 * vo.setStNo(Integer.parseInt(authentication.getName())); qnaDao.delOneQna(vo);
	 * redir.addFlashAttribute("success", "????????? ?????????????????????.");
	 * redir.addAttribute("sbjNo", vo.getSbjNo());
	 * 
	 * return "redirect:/stud/eclass/qnaList";
	 * 
	 * }
	 */

	
	@RequestMapping("/taskList")
	public String taskList(Model model, HttpServletRequest req, Authentication authentication) {
		
		//?????????????????? ??????
		StudentVO sv = new StudentVO();
		SubjectVO sb = new SubjectVO();
		sv.setNo(Integer.parseInt(authentication.getName()));
		sb.setNo(Integer.parseInt(req.getParameter("sbjNo")));
		List<SubjectVO> sbjli = map.selectOneSubTask(sv, sb);
		
		model.addAttribute("sbjli", sbjli);
		
		return "eclass/stud/taskList";
	}
	
	@RequestMapping("/taskSelect")
	public String taskSelect(Model model, TaskVO vo, HttpServletRequest req, Authentication authentication){
		
		vo.setNo(Integer.parseInt(req.getParameter("no")));
		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo")));
		
		SubmitTaskVO vo1 = new SubmitTaskVO();
		//???????????? ?????? ?????????
		vo1.setStNo(Integer.parseInt(authentication.getName()));
		//???????????????
		vo1.setTaskNo(vo.getNo());
		
		List<Map<String, Object>> tsk = sql.selectList("co.fourth.tuna.domain.task.mapper.TaskMapper.taskSelect", vo);
		List<SubmitTaskVO> fts = new ArrayList<>();
		if(taskDao.findSubmission(vo1).size() != 0) {
			fts = taskDao.findSubmission(vo1);
		}
		
		model.addAttribute("tsk", tsk);
		model.addAttribute("fts",fts);
		
		return "eclass/stud/taskSelect";
	}
	
	//?????? ??????
	@RequestMapping("/taskInsert")
	public String taskSubmission(TaskVO vo, Authentication authentication, 
			RedirectAttributes redir,
			@RequestParam(value = "file", defaultValue="") MultipartFile[] files) throws IOException {
		
		if(files.toString().equals("")) {
			return "redirect:/stud/eclass/taskSelect";
		}
			
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
		
		redir.addAttribute("no", vo.getNo());
		redir.addAttribute("sbjNo", vo.getSbjNo());
		
		return "redirect:/stud/eclass/taskSelect";
	}
	
	@DeleteMapping("/deleteSubmitTask")
	@ResponseBody
	public void deleteSubmitTask(@RequestBody SubmitTaskVO vo) {
		fileService.delete(vo.getUri(), "task");
		taskDao.deleteSubmitTask(vo);
		
	}
	
	@RequestMapping("/updateTaskFile")
	public String updateLectureFile(TaskVO vo, Authentication authentication, 
			RedirectAttributes redir, HttpServletRequest req,
			@RequestParam(value = "file", defaultValue="") MultipartFile[] files) throws IOException {
		
		SubmitTaskVO vo1 = new SubmitTaskVO();
		
		for(MultipartFile file : files) {
			String ogn = file.getOriginalFilename();
			
			if(ogn != null && ogn.length() != 0) {
				String[] tf = fileService.upload(file, "task");
				
				vo1.setFileName(tf[0]);
				vo1.setUri(tf[1]);
				vo1.setTaskNo(vo.getNo());
				vo1.setNo(Integer.parseInt(req.getParameter("fileNo")));
				
				taskDao.updateTaskFile(vo1);
			}
		}
		
		redir.addAttribute("no", vo.getNo());
		redir.addAttribute("sbjNo", vo.getSbjNo());
		
		return "redirect:/stud/eclass/taskSelect";
		
	}

	//?????????
	@RequestMapping("/download") 
	public String download(LectureFileVO vo, 
			Model model) {
		
		model.addAttribute("lectureFile", fileDao.lectureFileList(vo));
		
//		System.out.println("??????"+lectureFile.get(0).get("NO"));

		
		
//		List<LectureFileVO> fileList = new ArrayList<>();
//		if(fileDao.lectureFileDownload(vo).size() != 0) {
//			fileList = fileDao.lectureFileDownload(vo);
//		}
		
		return "eclass/stud/download";
	}
	
	//???????????? ???
	@Autowired private SubjectMapper map;
	@RequestMapping("/home")
	public String home(Model model,
			EclassStudentHomeVO vo, 
			Authentication authentication,
			HttpServletResponse res,
			@CookieValue(value="seasonCode", required=false, defaultValue="0") String seasonCode) {
		
		Cookie cookie = null;
		if(seasonCode.isBlank() || seasonCode.equals("0")) {
			seasonCode = year.yearFind();
		}
		
		if(vo.getSeasonCode() == null) {
			vo.setSeasonCode(Integer.parseInt(seasonCode));
			cookie = new Cookie("seasonCode", seasonCode);
		} else {
			cookie = new Cookie("seasonCode", vo.getSeasonCode().toString());
			cookie.setMaxAge(60*60*24);
			cookie.setSecure(true);
		}
		
		vo.setNo(Integer.parseInt(authentication.getName()));
		List<Map<String, Object>> list = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
		model.addAttribute("list", list);
		

		res.addCookie(cookie);
		
		
		List<Map<String, Object>> tt = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.twoTask", vo);
		model.addAttribute("tt", tt);
		
		return "eclass/stud/home";
	}
	
	//???????????????
	@RequestMapping("/lectureHome")
	public String lectureHome(Model model, EclassStudentHomeVO vo, HttpServletRequest req) {
		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo"))); 
		
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
	
	
	//??????
	@RequestMapping("/attendance")
	public String studentAttendance(Model model, AttendanceVO vo, 
			HttpServletRequest req, 
			Authentication authentication) {
		vo.setStNo(Integer.parseInt(authentication.getName()));
		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo")));
		
		List<Map<String, Object>> attd = sql.selectList("co.fourth.tuna.domain.attendance.mapper.AttendanceMapper.studentAttendance", vo);
		
		if(attd.size() > 16) {
			List<Map<String, Object>> major = attd; 
			model.addAttribute("major", major);
		}else{
			List<Map<String, Object>> refin = attd;
			model.addAttribute("refin", refin);
		};
		
		return "eclass/stud/attendance";
	}
	//???????????? ?????? ????????? ?????????
	@ModelAttribute("side")
	public Map<String, Object> side(Authentication authentication,
			Model model,
			HttpServletRequest req, HttpServletResponse res,
			@CookieValue(value="seasonCode", required=false, defaultValue="0") String seasonCode) {
		

		String seasonParam = req.getParameter("seasonCode");
		Cookie cookie = null;
		
		if(seasonParam != null && !seasonParam.isBlank()) {
			seasonCode = seasonParam;
		}
		
		if(seasonCode == null || seasonCode.isBlank() || seasonCode.equals("0")) {
			seasonCode = year.yearFind();
		}
		cookie = new Cookie("seasonCode", seasonCode);
		res.addCookie(cookie);
		
		
		EclassStudentHomeVO vo = new EclassStudentHomeVO();
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo.setSeasonCode(Integer.parseInt(seasonCode));
		
		Map<String, Object> sidemap = new HashMap<String, Object>();
		List<Map<String, Object>> list = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
		sidemap.put("side", list);
		
		model.addAttribute("seasonCode", seasonCode);
		model.addAttribute("side", list);
		
		return sidemap;
	}
}
