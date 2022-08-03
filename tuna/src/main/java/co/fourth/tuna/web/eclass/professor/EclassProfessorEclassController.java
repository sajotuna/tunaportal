package co.fourth.tuna.web.eclass.professor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.common.service.CodeService;
import co.fourth.tuna.domain.common.service.LectureScheduleService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.objection.service.ObjectionService;
import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.util.CustomDateUtills;

@Controller
@RequestMapping("/staff/eclass")
public class EclassProfessorEclassController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	LectureQnaService lectureService;
	@Autowired
	LectureNoticeService noticeService;
	@Autowired
	PortalScheduleService portalScheduleService;
	@Autowired
	ObjectionService objectionService;
	@Autowired
	LectureScheduleService lecScheduleService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	LecturePlanService lecPlanService;
	
	@Autowired
	YearService yearService;

	@Autowired
	CodeService codeService;

	private static final String WEB_PATH = "/staff/eclass";

	private static final Logger logger = LoggerFactory.getLogger(EclassProfessorEclassController.class);

	@GetMapping(value = { "", "/", "/home" })
	public String homeView(Model model, HttpServletRequest req, Authentication auth) {
//		logger.info(req.getRequestURI()); //tuna/eclass/professor/notice
//		logger.info(req.getRequestURL().toString()); //http://localhost/tuna/eclass/professor/notice
//		logger.info(req.getServletPath()); //eclass/professor/notice
//		System.out.println(new Object() {}.getClass().getEnclosingMethod().getAnnotation(GetMapping.class).value()[0]);

		ProfessorVO prof = new ProfessorVO();
		prof.setNo(Integer.parseInt(auth.getName()));

		int season = Integer.parseInt(yearService.yearFind());

		List<SubjectVO> subList = subjectService.findListForProfessorMain(prof, season, 1, 5);
		List<LectureQnaVO> qnaList = lectureService.findByProfessor(prof, 1, 5);
		List<LectureNoticeVO> noticeList = noticeService.findByProfessor(prof, 1, 5);

		model.addAttribute("subList", subList);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("noticeList", noticeList);

		return WEB_PATH + "/home";
	}

	@GetMapping("/notice")
	public String noticeView(Model model, HttpServletRequest req, @RequestParam(value = "no") int no) {

		model.addAttribute("notice", noticeService.findById(no));

		return req.getServletPath();
	}

	@GetMapping("/noticeForm")
	public String noticeFormView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "sbjno", required = false, defaultValue = "0") int sbjno) {
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(Integer.parseInt(auth.getName()));

		int selected = sbjno;
		List<SubjectVO> subjects = subjectService.findListByProfessorVO(prof);
		if (selected < 1) {
			selected = subjects.get(0).getNo();
		}

		model.addAttribute("subjects", subjects);
		model.addAttribute("selected", selected);
		return req.getServletPath();
	}

	@GetMapping("/noticeList")
	public String noticeListView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {

		ProfessorVO prof = new ProfessorVO();
		prof.setNo(Integer.parseInt(auth.getName()));

		List<LectureNoticeVO> noticeList = noticeService.findByProfessor(prof, pageNum, 15);
		List<LectureNoticeVO> noticeList2 = noticeService.findByProfessor(prof, 1, 999);
		int pageCount = (int) Math.ceil((double) noticeList2.size() / (15 + 1));

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageCount", pageCount);

		return req.getServletPath();
	}

	@GetMapping("/qna")
	public String qnaView(Model model, HttpServletRequest req, LectureQnaVO qna) {
		
		qna = lectureService.findLectureQnaByLecture(qna.getNo());
		model.addAttribute("qna", qna);

		return req.getServletPath();
	}

	@GetMapping("/qnaList")
	public String qnaListView(Model model, HttpServletRequest req, Authentication auth) {
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(Integer.parseInt(auth.getName()));
		List<LectureQnaVO> qnaList = lectureService.findByProfessor(prof, 1, 5);
		model.addAttribute("qnaList", qnaList);
		return req.getServletPath();
	}

	@GetMapping("/studentList")
	public String studentListView(Model model, HttpServletRequest req) {

		return req.getServletPath();
	}

	@GetMapping("/subject")
	public String subjectView(Model model, HttpServletRequest req,
			@RequestParam(value = "no", required = false, defaultValue = "0") int sbjno) {
		String season = yearService.yearFind();

		if (sbjno < 1) {
			return "redirect:/" + WEB_PATH;
		}
		SubjectVO subject = subjectService.findOneWithApplysAndRatioAndFilesById(sbjno);

		// 개강일 검색
		PortalScheduleVO schedule = portalScheduleService.findSeasonSchedule(season, "1101");

		// 개강일
		LocalDate firstDay = LocalDate.ofInstant(schedule.getStartDate().toInstant(), ZoneId.systemDefault());
		LocalDate startDate = firstDay.minusDays(1);

		// 시간표 목록
		List<LectureScheduleVO> subSche = lecScheduleService.findScheduleBySubjectId(sbjno);

		List<LocalDate> schedules = new ArrayList<LocalDate>();
		for (LectureScheduleVO lecSche : subSche) {
			schedules.add(startDate.with(TemporalAdjusters
					.next(DayOfWeek.of(CustomDateUtills.koreanWeeksToLocalDateNum(lecSche.getDayCode())))));
		}
		Collections.sort(schedules, (LocalDate d1, LocalDate d2) -> d1.compareTo(d2));
		
		LocalDate lectureStartDay = schedules.get(0);
		LocalDate lastDay = schedules.get(schedules.size() - 1).plusWeeks(15);
		
		Integer thisWeek = 0;
		
		LocalDate today = LocalDate.now();
		
		// 주차 계산
		List<LecturePlanVO> plans = lecPlanService.findListBySubjectId(sbjno);
		subjectService.thisWeekCalculator(plans, subSche);
		for(int i=0; i < plans.size(); i++) {
			for( LectureScheduleVO lecSche : subSche ) {
				LocalDate ldate = startDate.with(
					TemporalAdjusters.next(
						DayOfWeek.of(CustomDateUtills.koreanWeeksToLocalDateNum(lecSche.getDayCode()))
					)
				);
				if(today.compareTo(ldate) < 0) break;
			}
		}
		
		
		model.addAttribute("subject", subject);
		model.addAttribute("firstDay", lectureStartDay);
		model.addAttribute("lastDay", lastDay);
		
		return req.getServletPath();
	}

	@GetMapping("/subjectForm")
	public String subjectFormView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "no", required = false, defaultValue = "0") int no) {
		// TODO 내 강의 인지 검사
		SubjectVO subject = subjectService.findOneWithRatioAndScheduleAndPlanById(no);

		model.addAttribute("subject", subject);

		return req.getServletPath();
	}

	@GetMapping("/subjectList")
	public String subjectListView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "season", required = false, defaultValue = "0") int season) {

		ProfessorVO prof = new ProfessorVO();
		prof.setNo(Integer.parseInt(auth.getName()));

		if (season == 0) {
			season = Integer.parseInt(yearService.yearFind());
		}

		CodeMasterVO seasonMasterCode = codeService.findById("100");

		List<SubjectVO> subList = subjectService.findListForProfessorMain(prof, season, 1, 999);

		model.addAttribute("subList", subList);
		model.addAttribute("seasonCodes", seasonMasterCode);
		model.addAttribute("selectedSeason", season);
		return req.getServletPath();
	}

	@GetMapping("/objectionList")
	public String objectionListView(HttpServletRequest req, Authentication authentication, Model model) {

		List<Map<String, Object>> list = objectionService
				.objectionListOfProf(Integer.parseInt(authentication.getName()), "all");
		model.addAttribute("objList", list);

		CodeMasterVO seasonCodes = codeService.findById("100");
		model.addAttribute("seasonCodes", seasonCodes);

		return req.getServletPath();
	}

}
