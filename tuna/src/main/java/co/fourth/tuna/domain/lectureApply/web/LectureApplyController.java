package co.fourth.tuna.domain.lectureApply.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.captcha.CaptchaUtil;
import co.fourth.tuna.domain.common.service.DateCheckService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.lectureApply.service.LectureApplyService;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import nl.captcha.Captcha;

@Controller
public class LectureApplyController {

	@Autowired
	private LectureApplyService LectureApplyDao;
	@Autowired
	private YearService yearDao; 
	@Autowired
	private SqlSession SqlSession;
	@Autowired
	private DateCheckService DataDao;
	
	@RequestMapping("/stud/course/Warning")
	public String courseWarning() {
		return "course/apply/courseWarning";
	}
	
	@RequestMapping("/stud/course/Application")
	public String courseApplication(Model model,LectureApplyVO vo, Authentication authentication,@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum, 
			  @RequestParam Map<String, Object> params ) {

//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1104") != 1) {
//			model.addAttribute("error", "현재 수강신청 열람기간이 아닙니다.");
//			return "schedule/date/courseDate";
//		}
//		
		
		params.put("pageNum", pageNum);
		params.put("size", 10);
		params.put("seasonCode", yearDao.yearFind());
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		vo.setStateCode("402");
		int grade = Integer.parseInt(LectureApplyDao.FindApplyGrade(vo));
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind", params);
		List<Map<String,Object>> courLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseFind",vo);
		List<Map<String,Object>> baskLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket",vo);
		model.addAttribute("list", lists);
		model.addAttribute("courList", courLists);
		model.addAttribute("grade", grade);
		model.addAttribute("baskList", baskLists);
		model.addAttribute("params", params);
		return "course/apply/courseApplication";
	}
	
	@RequestMapping("/stud/course/ApplyInsert")
	public String courseApplyInsert(RedirectAttributes ra,Authentication authentication, LectureApplyVO vo, String sbjno){
		
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		vo.setSbjNo(sbjno);
		
		int grade = Integer.parseInt(LectureApplyDao.FindApplyGrade(vo));
		String target = LectureApplyDao.subjectTarget(vo);
		
		if(target == null || target == "") {
			ra.addFlashAttribute("error", "잘못된 과목코드입니다. 과목코드를 제대로 입력해주세요.");
			return "redirect:/stud/course/Application";
		}
		
		
		if(grade - Integer.parseInt(target) < 0) {
			ra.addFlashAttribute("error", "수강신청 가능한 학점이 없습니다.");
			return "redirect:/stud/course/Application";
		}
		String message = LectureApplyDao.ApplyErrorMsg(vo);
		
		System.out.println(message);
		if(message.equals("수강신청이 완료되었습니다.")) {
			ra.addFlashAttribute("success", message);
			return "redirect:/stud/course/Application";
		}
		
		ra.addFlashAttribute("error", message);
		return "redirect:/stud/course/Application";
	}
	
	@RequestMapping("/stud/course/ApplyDelete")
	public String courseDelete(Authentication authentication,RedirectAttributes ra, LectureApplyVO vo) {
		vo.setStNo(authentication.getName());
		LectureApplyDao.CourseDelete(vo);
		ra.addFlashAttribute("success", "삭제가 완료되었습니다.");
		return "redirect:/stud/course/Application";
	}
	
	
	@RequestMapping("/stud/course/ApplyLectureList")
	public String courseApplicationLectureList(Model model, Authentication authentication, LectureApplyVO vo) {
		
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		List<Map<String,Object>> courLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseFind",vo);
		
		model.addAttribute("courList", courLists);
		
		return "course/apply/courseApplicationLectureList";
	}
	
	@RequestMapping("/stud/course/ApplySchedule")
	public String courseApplicationSchedule() {
		return "course/apply/courseApplicationSchedule";
	}

	// captcha 이미지 가져오는 메서드
	@GetMapping("/stud/course/captchaImg.do")
	@ResponseBody
	public void captchaImg(HttpServletRequest req, HttpServletResponse res) throws Exception {
		new CaptchaUtil().getImgCaptCha(req, res);
	}

	// 전달받은 문자열로 음성 가져오는 메서드
	@GetMapping("/stud/course/captchaAudio.do")
	@ResponseBody
	public void captchaAudio(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String getAnswer = captcha.getAnswer();
		new CaptchaUtil().getAudioCaptCha(req, res, getAnswer);
	}

	// 사용자가 입력한 보안문자 체크하는 메서드
	@PostMapping("/stud/course/chkAnswer.do")
	@ResponseBody
	public String chkAnswer(HttpServletRequest req, HttpServletResponse res) {
		String result = "";
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String ans = req.getParameter("answer");
		
		if (ans != null && !"".equals(ans)) {
			if (captcha.isCorrect(ans)) {
				req.getSession().removeAttribute(Captcha.NAME);
				result = "200";
			} else {
				result = "300";
			}
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/stud/course/ApplyScheduleCheck")
	public List<LectureBasketVO> BasketSchedule(Authentication authentication, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		return SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseSchedule", vo);
	}
	
	// 내 수강내역
	@GetMapping("/stud/portal/mySubjectList")
	@ResponseBody
	public List<Map<String,Object>> mySubjectList(LectureApplyVO vo) {
		List<Map<String,Object>> mySubjects = LectureApplyDao.mySubjectList(vo);
		return mySubjects;
	}

}
