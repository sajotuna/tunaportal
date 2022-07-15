package co.fourth.tuna.domain.lectureplan.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;

@Controller
public class LecturePlanController {

	@Autowired private SqlSession sql;
	
	@RequestMapping("/eclass/student/lecturePlan")
	public String lecturePlan(Model model, LecturePlanVO vo) {
		vo.setSbjNo(18101);
		List<Map<String,Object>> lists = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectPlan", vo.getSbjNo());
		//강의스케쥴
		List<Map<String,Object>> lectureSchedule = sql.selectList("co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper.selectSc", vo.getSbjNo());
		
//		System.out.println(listz.get(0).toString());
		
		String[] plan = lists.get(0).values().toString().split(",");
		
		String[] weekplan = plan[11].split("/");
		
		for(int i =0; i<plan.length;i++) {
			System.out.println(plan[i]);
		}
		model.addAttribute("sc", lectureSchedule.get(0));
		model.addAttribute("plan", lists.get(0));
		model.addAttribute("weekplan", weekplan);
		return "eclass/stud/lecturePlan";
	}

}
