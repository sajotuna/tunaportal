package co.fourth.tuna.web.portal.student;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.service.DateCheckService;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.grade.service.GradeService;

@Controller
public class PortalStudentController {
	
	private static Logger logger = LoggerFactory.getLogger(PortalStudentController.class); 
	
	@Autowired GradeService gradeDao;
	@Autowired YearService yearDao;
	@Autowired DateCheckService dateCheckDao;
	
	// 강의/성적 조회
	@RequestMapping("/stud/portal/subjectAndReport")
	public String subjectAndRoport(Authentication authentication, Model model) {
		
		List<Map<String, Object>> avgGrades = gradeDao.avgGradeSelect(Integer.parseInt(authentication.getName()),
																	  yearDao.yearFind());
		
		int totalPoint = 0;
		double totalAvg = 0;
		
		for (int i=0; i<avgGrades.size(); i++) {
			totalPoint += Double.valueOf(String.valueOf(avgGrades.get(i).get("SUM")));
			totalAvg += Double.valueOf(String.valueOf(avgGrades.get(i).get("AVG")));
		}
		
		double totalGrade = 0;
		if(avgGrades.size() != 0) {
			totalGrade = totalAvg / avgGrades.size();
		}
		double totalPct = ( totalGrade / 4.5 ) * 100;
		
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("totalGrade", totalGrade);
		model.addAttribute("totalPct", totalPct);
		
		return "portal/stud/subjectAndReport";
	}
	
	// 당해학기 성적 조회
	@RequestMapping("/stud/portal/currentSemesterGrade")
	public String currentSemesterGrade(Authentication authentication, 
										Model model, 
										RedirectAttributes redirectAttributes) {
		
		List<Map<String, Object>> grades = gradeDao.currentSemesterGradeSelect(Integer.parseInt(authentication.getName()), 
																				yearDao.yearFind());
		Map<String, Object> total = gradeDao.currentSemesterGradeTotal(Integer.parseInt(authentication.getName()), 
																		yearDao.yearFind());
		
		int result = dateCheckDao.accessDateCheck(yearDao.yearFind(), "1106");
		
		//if (result > 0) {
			
			boolean findN = false;
			for (int i=0; i<grades.size(); i++) {
				if (grades.get(i).get("EVALSTATE").toString().equals("N")) {
					findN = true;
				}
			}
			if (findN) {
				total.put("AVG", "비공개");
			}
			
			model.addAttribute("grades", grades);
			model.addAttribute("total", total);
			return "portal/stud/currentSemesterGrade";
			
//		} else {
//			redirectAttributes.addFlashAttribute("message", "지금은 성적 조회 기간이 아닙니다.");
//			return "redirect:/home";
//		}
		
	}
	
}
