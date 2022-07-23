package co.fourth.tuna.domain.grade.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.grade.service.GradeService;

@RestController
public class GradeController {
	
	@Autowired 
	private GradeService gradeDao;
	@Autowired
	private YearService yearDao;
	
	// 보관 성적 조회 - 과목별 성적 내역
	@RequestMapping("/stud/portal/subjectGrade")
	public List<Map<String, Object>> subjectGrade(int stNo){
		return gradeDao.subjectGradeSelect(stNo, yearDao.yearFind());
	}
	
	// 보관 성적 조회 - 과목별 성적 내역(연도/학기별)
	@RequestMapping("/stud/portal/seasonSubjectGrade")
	public List<Map<String, Object>> seasonSubjectGrade(int stNo, String seasonCode){
		return gradeDao.seasonSubjectGradeSelect(stNo, seasonCode);
	}
	
	// 보관 성적 조회 - 평균 평점
	@RequestMapping("/stud/portal/avgGrade")
	public List<Map<String, Object>> avgGrade(int stNo){
		return gradeDao.avgGradeSelect(stNo, yearDao.yearFind());
	}
	
	//
}
