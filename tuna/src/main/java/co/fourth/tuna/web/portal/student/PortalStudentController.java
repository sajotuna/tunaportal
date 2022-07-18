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

import co.fourth.tuna.domain.banner.web.BannerController;
import co.fourth.tuna.domain.grade.service.GradeService;

@Controller
public class PortalStudentController {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired GradeService gradeDao;
	
	// 강의/성적 조회
	@RequestMapping("/stud/subjectAndReport")
	public String subjectAndRoport(Authentication authentication, Model model) {
		
		List<Map<String, Object>> avgGrades = gradeDao.avgGradeSelect(Integer.parseInt(authentication.getName()));
		
		int totalPoint = 0;
		double totalAvg = 0;
		
		for (int i=0; i<avgGrades.size(); i++) {
			totalPoint += Double.valueOf(String.valueOf(avgGrades.get(i).get("SUM")));
			totalAvg += Double.valueOf(String.valueOf(avgGrades.get(i).get("AVG")));
		}
		
		double totalGrade = totalAvg / avgGrades.size();
		double totalPct = ( totalGrade / 4.5 ) * 100;
		
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("totalGrade", totalGrade);
		model.addAttribute("totalPct", totalPct);
		
		return "portal/stud/subjectAndReport";
	}
	
	// 당해학기 성적 조회
	@RequestMapping("/stud/currentSemesterGrade")
	public String currentSemesterGrade() {
		return "portal/stud/currentSemesterGrade";
	}
	
}
