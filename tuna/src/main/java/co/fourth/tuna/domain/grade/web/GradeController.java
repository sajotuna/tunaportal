package co.fourth.tuna.domain.grade.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;

@RestController
public class GradeController {
	
	@Autowired 
	private GradeService gradeDao;
	
	// 보관 성적 조회 - 과목별 성적 내역
	@RequestMapping("/stud/subjectGrade")
	public List<Map<String, Object>> subjectGrade(int stNo){
		List<Map<String, Object>> subjectGrades = gradeDao.subjectGradeSelect(stNo);
		return subjectGrades;
	}
	
	// 보관 성적 조회 - 과목별 성적 내역(연도/학기별)
	@RequestMapping("/stud/seasonSubjectGrade")
	public List<Map<String, Object>> seasonSubjectGrade(int stNo, String seasonCode){
		List<Map<String, Object>> subjectGrades = gradeDao.seasonSubjectGradeSelect(stNo, seasonCode);
		return subjectGrades;
	}
	
	// 보관 성적 조회 - 평균 평점
	@RequestMapping("/stud/avgGrade")
	public List<Map<String, Object>> avgGrade(int stNo){
		List<Map<String, Object>> avgGrade = gradeDao.avgGradeSelect(stNo);
		return avgGrade;
	}
	
	//
	@PostMapping("/prof/updateGrades")
	public ResponseEntity<String> updateGrades(
			@RequestBody List<GradeFormVO> grades) {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json;charset");
		
		ResponseEntity<String> resEntity = null;
		try {
			resEntity = new ResponseEntity<String>(
					gradeDao.updateGradeList(grades), 
					resHeaders, 
					HttpStatus.OK);
		} catch (Error e) {
			resEntity = new ResponseEntity<String>(
				e.getMessage(),
				resHeaders,
				HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(
				e.getMessage(),
				resHeaders,
				HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
				
	}
	
	
}
