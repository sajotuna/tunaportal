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

import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

@Controller
public class LectureBasketController {

	@Autowired
	private SqlSession SqlSession;
	@Autowired
	private LectureBasketService LectureBasketDao;
	
	@RequestMapping("/stud/courseBasket")
	public String courseBasket(Model model,LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind");
		List<Map<String,Object>> baskLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket",vo.getStNo());
		
		model.addAttribute("list", lists);
		model.addAttribute("baskList", baskLists);
		
		return "course/basket/courseBasket";
	}
	
	@RequestMapping("/stud/basketInsert")
	public String basketInsert(Model model,@RequestParam List<String> courcheck, LectureBasketVO vo, Authentication authentication) {
		System.out.println(courcheck);
		vo.setStNo(authentication.getName());
		for (String sbj : courcheck) {
			String[] sbjarr = sbj.split(",");
			vo.setSbjNo(sbjarr[0]);
			vo.setSeasonCode(sbjarr[1]);
			LectureBasketDao.baskInsert(vo);
        }
		
		
		return "redirect:/stud/courseBasket";
	}
	
	@RequestMapping("/stud/courseBasketLectureList")
	public String courseBasketLectureList(Model model,LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> baskLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket",vo.getStNo());
		model.addAttribute("baskList", baskLists);
		
		return "course/basket/courseBasketLectureList";
	}
	
	@RequestMapping("/stud/courseBasketSchedule")
	public String courseBasketSchedule(Model model,LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> baskLists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket",vo.getStNo());
		model.addAttribute("baskList", baskLists);
		
		return "course/basket/courseBasketSchedule";
	
	
	}
}
