package co.fourth.tuna.domain.lectureplan.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;

@Controller
public class LecturePlanController {

	@Autowired private LecturePlanService dao;
	@Autowired private SqlSession sql;
	
	@RequestMapping("/student/lecturePlan")
	public String lecturePlan(Model model, LecturePlanVO vo) {
		vo.setSbjNo(18101);
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		     
		System.out.println(lists.get(0).toString());
		
		String[] plankey = lists.get(0).keySet().toString().split("=");
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[9].split("/");
		
		
		for(int i =0; i<plankey.length-1;i++) {
			System.out.println(plankey[i]);
		}
		
		/*
		 * Map<String,Object> map = new HashMap<String,Object>();
		 * 
		 * for(int i=0; i< plan.length-1; i++) { map.put(plankey[i], plan[i]); }
		 */
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		for(int i=0; i<weekplan.length-1; i++) {
			map2.put((i+1)+"주차", weekplan[i]);
		}
		
		
		//System.out.println(map.toString());
		System.out.println(map2.toString());
		
		model.addAttribute("plankey", plankey);
		model.addAttribute("map2", map2);
		return "eclass/stud/lecturePlan";
	}
}
