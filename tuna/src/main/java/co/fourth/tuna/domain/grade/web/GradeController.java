package co.fourth.tuna.domain.grade.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.util.CustomException;
import co.fourth.tuna.util.ResponseMsg;

@RestController
public class GradeController {
	
	@Autowired 
	private GradeService gradeDao;
	@Autowired
	private YearService yearDao;
	@Autowired
	private TaskService taskService;
	
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
	@PostMapping("/staff/updateGrades")
	public ResponseEntity<ResponseMsg> updateGrades(
			@RequestBody List<GradeFormVO> grades) {
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<ResponseMsg> resEntity = null;
		
		try {
			resEntity = new ResponseEntity<ResponseMsg>(
					gradeDao.updateGradeListByGradeNo(grades), 
					resHeaders, 
					HttpStatus.OK);			
		} catch ( CustomException e) {
			resEntity = new ResponseEntity<ResponseMsg>(
					e.getResMsg(), 
					resHeaders, 
					HttpStatus.OK);
		}
		
		return resEntity;
				
	}
	
	@PostMapping("/staff/updateGrade")
	public ResponseEntity<String> updateGrade(
			@RequestBody GradeFormVO grade) {
		return null;
	}
	
	@PostMapping(value="/staff/eclass/updateSubmitTaskScore")
	public ResponseEntity<String> updateSubmitTaskScore(
			@RequestBody EclassSubmitTaskScoreForm data) {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> res = null;
		
		try {
			res = new ResponseEntity<String>(
					gradeDao.updateSubmitTaskGrade(data),
					resHeaders,
					HttpStatus.OK);
		} catch (Throwable e) {
			res = new ResponseEntity<String>(
					e.getMessage(),
					resHeaders,
					HttpStatus.BAD_REQUEST);
		}
		
		return res;
	}
}
