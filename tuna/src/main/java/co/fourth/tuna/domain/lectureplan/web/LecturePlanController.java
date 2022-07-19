package co.fourth.tuna.domain.lectureplan.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;

@Controller
public class LecturePlanController {

	@Autowired private SqlSession sql;
	@Autowired private LecturePlanService service;
	@Autowired private YearService yService;
	@Autowired private PortalScheduleService scheduleService;
	
	@RequestMapping("/portal/student/lecturePlan")
	@ResponseBody
	public List<Map<String,Object>> lecturePlanModal(Model model, LecturePlanVO vo) {
		
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
		for (Map<String,Object> ls : lectureSchedule) {
			lists.add(ls);
		}
		
		String[] plan = lists.get(0).values().toString().split(",");
		String[] weekplan = plan[11].split("~");
		
		Map<String, Object> map = new HashMap<>();
		
		for(int i=1; i<=weekplan.length; i++) {
			map.put(Integer.toString(i), weekplan[(i-1)]);
		}
		
		lists.add(map);

		return lists;
	}
	
	@RequestMapping("/stud/CoursePlan")
	public String CoursePlan(Model model, LecturePlanVO vo) {
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		//강의스케쥴
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
//		System.out.println(listz.get(0).toString());
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[11].split("~");
		
		for(int i =0; i<plan.length;i++) {
			System.out.println(plan[i]);
		}
		model.addAttribute("sc", lectureSchedule.get(0));
		model.addAttribute("plan", lists.get(0));
		model.addAttribute("weekplan", weekplan);
		return "course/apply/coursePlan";
	}
	
	
	
	@RequestMapping("/eclass/student/lecturePlan")
	public String lecturePlan(Model model, LecturePlanVO vo) {
		vo.setSbjNo(18101);
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		//강의스케쥴
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
//		System.out.println(listz.get(0).toString());
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[11].split("~");
		
		for(int i =0; i<plan.length;i++) {
			System.out.println(plan[i]);
		}
		model.addAttribute("sc", lectureSchedule.get(0));
		model.addAttribute("plan", lists.get(0));
		model.addAttribute("weekplan", weekplan);
		return "eclass/stud/lecturePlan";
	}
	
	@PostMapping("/prof/lecPlans")
	@ResponseBody
	public List<LecturePlanVO> getLecturePlansBySubjectId(
			@RequestBody Map<String, Integer> reqData){
		String season = yService.yearFind();
		
		
		List<LecturePlanVO> resultData = service.findListBySubjectId(reqData.get("sbjno"));
		PortalScheduleVO schedule = scheduleService.findSeasonSchedule(season, "1101");
		System.out.println(schedule);
		return resultData;  
	}
}
