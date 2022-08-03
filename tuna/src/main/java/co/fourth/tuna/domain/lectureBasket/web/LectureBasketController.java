package co.fourth.tuna.domain.lectureBasket.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.service.DateCheckService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

@Controller
public class LectureBasketController {

	@Autowired
	private SqlSession SqlSession;
	@Autowired
	private YearService yearDao;
	@Autowired
	private LectureBasketService LectureBasketDao;
	@Autowired
	private SubjectService sbjDao;
	@Autowired
	private DateCheckService DataDao;
	
	@RequestMapping("/stud/course/Basket")
	public String courseBasket(Model model, LectureBasketVO vo, Authentication authentication, 
							 @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum, 
							  @RequestParam Map<String, Object> params ) {

		
//		if(DataDao.accessDateCheck(yearDao.yearFind(), "1103") != 1) {
//			model.addAttribute("error", "현재 수강꾸러미 열람기간이 아닙니다.");
//			return "schedule/date/basketDate";
//		}
		SubjectVO sbj = new SubjectVO();
		params.put("pageNum", pageNum);
		params.put("size", 10);
		params.put("seasonCode", yearDao.yearFind());
		
		params.put("pageSize", Math.ceil((double)sbjDao.subjectCount(params)/10));
		vo.setSeasonCode(yearDao.yearFind());
		vo.setStNo(authentication.getName());
		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind", params);
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo);
		
		int grade = Integer.parseInt(LectureBasketDao.FindCourseGrade(vo));
		
		System.out.println(grade);
		model.addAttribute("params", params);
		model.addAttribute("list", lists);
		model.addAttribute("grade", grade);
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasket";
	}

	@SuppressWarnings({ "null"})
	@RequestMapping("/stud/course/basketInsert")
	public String basketInsert(RedirectAttributes ra, @RequestParam(defaultValue = "") List<String> courcheck, LectureBasketVO vo,
			Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		int grade = Integer.parseInt(LectureBasketDao.FindCourseGrade(vo));
		
		if(courcheck.isEmpty()) {
			ra.addFlashAttribute("error", "수강꾸러미에 담을 과목을 체크해주세요");
			return "redirect:/stud/course/Basket";
		}
		
		for (String sbj : courcheck) {
			
			vo.setSbjNo(sbj);
			String message = LectureBasketDao.basketApplyMsg(vo);
			int target = LectureBasketDao.subjectTarget(vo);
			grade -= target;
			if(grade < 0) {
				ra.addFlashAttribute("error", "수강신청 가능한 학점이 없습니다.");
				return "redirect:/stud/course/Basket";
			}
			if(message != null) {
				ra.addFlashAttribute("error", message);
				return "redirect:/stud/course/Basket";
			}
		}
		ra.addFlashAttribute("success", "수강꾸러미 등록이 완료되었습니다.");
		return "redirect:/stud/course/Basket";

	}

	@RequestMapping("/stud/course/basketDelete")
	public String basketDelete(Authentication authentication, RedirectAttributes ra, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		LectureBasketDao.baskDelete(vo);
		ra.addFlashAttribute("success", "수강꾸러미 내역의 삭제가 완료되었습니다.");
		return "redirect:/stud/course/Basket";
	}

	@RequestMapping("/stud/course/BasketLectureList")
	public String courseBasketLectureList(Model model, LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo);
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasketLectureList";
	}
	
	@RequestMapping("/stud/course/BasketSchedule")
	public String courseBasketSchedule(Model model, LectureBasketVO vo, Authentication authentication) {

		return "course/basket/courseBasketSchedule";

	}
	
	@ResponseBody
	@RequestMapping("/stud/course/BasketScheduleCheck")
	public List<LectureBasketVO> BasketSchedule(Authentication authentication, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode(yearDao.yearFind());
		return SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.BasketSchedule", vo);
	}
	
	
}
