package co.fourth.tuna.domain.lectureBasket.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

@Controller
public class LectureBasketController {

	@Autowired
	private SqlSession SqlSession;
	@Autowired
	private LectureBasketService LectureBasketDao;

	@RequestMapping("/stud/courseBasket")
	public String courseBasket(Model model, LectureBasketVO vo, Authentication authentication, 
							 @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum, 
							  @RequestParam Map<String, Object> params ) {

		params.put("pageNum", pageNum);
		params.put("size", 10);

		vo.setStNo(authentication.getName());
		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind", params);
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo.getStNo());
		
		int grade = Integer.parseInt(LectureBasketDao.FindCourseGrade(vo));
		
		System.out.println(grade);
		model.addAttribute("params", params);
		model.addAttribute("list", lists);
		model.addAttribute("grade", grade);
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasket";
	}

	@RequestMapping("/stud/basketInsert")
	public String basketInsert(RedirectAttributes ra, @RequestParam List<String> courcheck, LectureBasketVO vo,
			Authentication authentication) {
		vo.setStNo(authentication.getName());
		vo.setSeasonCode("106");
		int grade = Integer.parseInt(LectureBasketDao.FindCourseGrade(vo));
		
		for (String sbj : courcheck) {
			vo.setSbjNo(sbj);
			String message = LectureBasketDao.basketApplyMsg(vo);
			int target = LectureBasketDao.subjectTarget(vo);
			grade -= target;
			if(grade < 0) {
				ra.addFlashAttribute("message", "수강신청 가능한 학점이 없습니다.");
				return "redirect:/stud/courseBasket";
			}
			if(message == null || message.equals("")) {
				LectureBasketDao.baskInsert(vo);
			}else {
				ra.addFlashAttribute("message", message);
				return "redirect:/stud/courseBasket";
			}
		}
		ra.addFlashAttribute("message", "수강신청이 완료되었습니다.");
		return "redirect:/stud/courseBasket";

	}

	@RequestMapping("/stud/basketDelete")
	public String basketDelete(Authentication authentication, RedirectAttributes ra, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		LectureBasketDao.baskDelete(vo);
		ra.addFlashAttribute("message", "삭제가 완료되었습니다.");
		return "redirect:/stud/courseBasket";
	}

	@RequestMapping("/stud/courseBasketLectureList")
	public String courseBasketLectureList(Model model, LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo.getStNo());
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasketLectureList";
	}

	@RequestMapping("/stud/courseBasketSchedule")
	public String courseBasketSchedule(Model model, LectureBasketVO vo, Authentication authentication) {

		return "course/basket/courseBasketSchedule";

	}
	
	@ResponseBody
	@RequestMapping("/stud/BasketSchedule")
	public List<LectureBasketVO> BasketSchedule(Authentication authentication, LectureBasketVO vo) {
		vo.setStNo(authentication.getName());
		return SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.BasketSchedule", vo);
	}
	
	
}
