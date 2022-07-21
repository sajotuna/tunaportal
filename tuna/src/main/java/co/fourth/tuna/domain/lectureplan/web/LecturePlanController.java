package co.fourth.tuna.domain.lectureplan.web;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
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

import co.fourth.tuna.domain.common.service.CodeService;
import co.fourth.tuna.domain.common.service.LectureScheduleService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.common.vo.PlaceAndDateVO;
import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;
import co.fourth.tuna.util.CustomDateUtills;

@Controller
public class LecturePlanController {
	
	@Autowired private SqlSession sql;
	@Autowired private LecturePlanService service;
	@Autowired private YearService yService;
	@Autowired private PortalScheduleService scheduleService;
	@Autowired private LectureScheduleService lecScheduleService;
	
	@Autowired private CodeService codeService;
	
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
	
	
	
	
	@PostMapping("/prof/lecPlans")
	@ResponseBody
	public List<LecturePlanVO> getLecturePlansBySubjectId(
			@RequestBody Map<String, Integer> reqData){
		String season = yService.yearFind();
		List<LecturePlanVO> resultData = new ArrayList<LecturePlanVO>();
		// 요일 목록
		List<LectureScheduleVO> subSche = lecScheduleService.findScheduleBySubjectId(reqData.get("sbjno"));
		
		// 개강일 검색
		PortalScheduleVO schedule = scheduleService.findSeasonSchedule(season, "1101");
		// 개강일
		LocalDate firstDay = LocalDate.ofInstant(schedule.getStartDate().toInstant(), ZoneId.systemDefault());
		LocalDate startDate = firstDay.minusDays(1);
		
		
		resultData = service.findListBySubjectId(reqData.get("sbjno"));
		for(int i=0; i < resultData.size(); i++) {
			List<PlaceAndDateVO> pdvos = new ArrayList<PlaceAndDateVO>();
			for(LectureScheduleVO lecSche : subSche) {
				PlaceAndDateVO pdvo = new PlaceAndDateVO();
				pdvo.setRoomCode(lecSche.getRoomCode());
				pdvo.setRoomName(codeService.getName(lecSche.getRoomCode()));
				LocalDate ldate = startDate.with(TemporalAdjusters.next(
						DayOfWeek.of(CustomDateUtills.koreanWeeksToLocalDateNum(lecSche.getDayCode()))
					));
				pdvo.setLocalDate(ldate.plusWeeks((Integer.parseInt(resultData.get(i).getWkCode())-1200 -1)));
				pdvos.add(pdvo);
			}
			resultData.get(i).setPlaceAndDate(pdvos);
		}
		
		return resultData;
	}
}
