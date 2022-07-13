package co.fourth.tuna.domain.lectureBasket.web;

import java.util.HashMap;
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
	public String courseBasket(Model model,LectureBasketVO vo, Authentication authentication, String pageNum) {
		Map<String, Object> params = new HashMap<>();
		
		if(pageNum == null )
		{
			params.put("pageNum", 1);
		}else {
			params.put("pageNum", pageNum);
		}
		params.put("size", 10);
		
		
		
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind",params);
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
			if(sbjarr[2].indexOf("/") != -1) {
				String stNo = authentication.getName();
				String[] day = sbjarr[2].split("/");
				String[] dayTime = sbjarr[3].split(" ");
				String[] time = null;
				
				System.out.println(day[0] + "||||||" +day[1]);
				
				
				
				for(int i =0; i<day.length-1; i++) {
					time = dayTime[i].split("~");
					System.out.println("day "+i+":" + day[i]);
					System.out.println("dayTime : " + dayTime[i]);
				}
				for(int i=0; i<time.length-1; i++) {
					System.out.println("time:" + time[i]);
				}
				
				
				for(int i =0; i<day.length-1; i++) {
					
					System.out.println(stNo + day[i] + time[i+i] + time[i+i+1]);
					
					//boolean tf = LectureBasketDao.FindRoom(stNo,day[i], time[i+i], time[i+i+1]);
					//System.out.println(tf);
				}
				
			}
			//LectureBasketDao.baskInsert(vo);
        }
		
		
		return "redirect:/stud/courseBasket";
	}
	
	@RequestMapping("/stud/basketDelete")
	public String basketDelete(Model model, LectureBasketVO vo) {
		
		LectureBasketDao.baskDelete(vo);
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
