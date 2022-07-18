package co.fourth.tuna.domain.lectureApply.web;

import java.util.HashMap;
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

import co.fourth.tuna.domain.lectureApply.service.LectureApplyService;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import co.fourth.tuna.util.captcha.CaptchaUtil;
import nl.captcha.Captcha;

@Controller
public class LectureApplyController {

	@Autowired
	private LectureApplyService LectureApplyDao;
	
	@Autowired
	private SqlSession SqlSession;
	
	@RequestMapping("/stud/courseWarning")
	public String courseWarning() {
		return "course/apply/courseWarning";
	}
	
	@RequestMapping("/stud/courseApplication")
	public String courseApplication(Model model,LectureApplyVO vo, Authentication authentication,@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum, 
			  @RequestParam Map<String, Object> params ) {

		params.put("pageNum", pageNum);
		params.put("size", 10);
		
		vo.setStNo(authentication.getName());
		vo.setStateCode("402");
		int grade = Integer.parseInt(LectureApplyDao.FindApplyGrade(vo));
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind", params);
		List<Map<String,Object>> courLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseFind",vo.getStNo());
		List<Map<String,Object>> baskLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket",vo);
		model.addAttribute("list", lists);
		model.addAttribute("courList", courLists);
		model.addAttribute("grade", grade);
		model.addAttribute("baskList", baskLists);
		model.addAttribute("params", params);
		return "course/apply/courseApplication";
	}
	
	@RequestMapping("/stud/courseApplyInsert")
	public String courseApplyInsert(RedirectAttributes ra,Authentication authentication, LectureApplyVO vo, String sbjno){
		
		vo.setStNo(authentication.getName());
		vo.setSeasonCode("106");
		vo.setSbjNo(sbjno);
		
		int grade = Integer.parseInt(LectureApplyDao.FindApplyGrade(vo));
		int target = LectureApplyDao.subjectTarget(vo);
		
		if(grade - target < 0) {
			ra.addFlashAttribute("message", "수강신청 가능한 학점이 없습니다.");
			return "redirect:/stud/courseBasket";
		}
		String message = LectureApplyDao.ApplyErrorMsg(vo);
		
		System.out.println(message);
		if(message.equals("수강신청이 완료되었습니다.")) {
			LectureApplyDao.CourseInsert(vo);
		}
		
		ra.addFlashAttribute("message", message);
		return "redirect:/stud/courseApplication";
	}
	
	@RequestMapping("/stud/courseDelete")
	public String courseDelete(Authentication authentication,RedirectAttributes ra, LectureApplyVO vo) {
		vo.setStNo(authentication.getName());
		LectureApplyDao.CourseDelete(vo);
		ra.addFlashAttribute("message", "삭제가 완료되었습니다.");
		return "redirect:/stud/courseApplication";
	}
	
	
	@RequestMapping("/stud/courseApplicationLectureList")
	public String courseApplicationLectureList(Model model, Authentication authentication, LectureApplyVO vo) {
		
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> courLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseFind",vo.getStNo());
		
		model.addAttribute("courList", courLists);
		
		return "course/apply/courseApplicationLectureList";
	}
	
	@RequestMapping("/stud/courseApplicationSchedule")
	public String courseApplicationSchedule() {
		return "course/apply/courseApplicationSchedule";
	}
	
	@RequestMapping("/coursesreg")
	public String coursesReg() {
		return "course/apply/courseApplication";
	}

	// captcha 이미지 가져오는 메서드
	@GetMapping("/stud/captchaImg.do")
	@ResponseBody
	public void captchaImg(HttpServletRequest req, HttpServletResponse res) throws Exception {
		new CaptchaUtil().getImgCaptCha(req, res);
	}

	// 전달받은 문자열로 음성 가져오는 메서드
	@GetMapping("/stud/captchaAudio.do")
	@ResponseBody
	public void captchaAudio(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String getAnswer = captcha.getAnswer();
		new CaptchaUtil().getAudioCaptCha(req, res, getAnswer);
	}

	// 사용자가 입력한 보안문자 체크하는 메서드
	@PostMapping("/stud/chkAnswer.do")
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
	@RequestMapping("/stud/CourseSchedule")
	public List<LectureBasketVO> BasketSchedule(Authentication authentication, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		return SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseSchedule", vo);
	}
	
	// 내 수강내역
	@GetMapping("/stud/mySubjectList")
	@ResponseBody
	public List<Map<String,Object>> mySubjectList(LectureApplyVO vo) {
		List<Map<String,Object>> mySubjects = LectureApplyDao.mySubjectList(vo);
		return mySubjects;
	}

}
