package co.fourth.tuna.domain.subject.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectUpdateForm;
import co.fourth.tuna.domain.subject.vo.SubjectVO;


@Controller
public class SubjectController {
	
	@Autowired SqlSession SqlSession;
	@Autowired SubjectService subjectDao;
	@Autowired LecturePlanService lecPlanService;
	
	@ResponseBody
	@RequestMapping("/courseCheck")
	public List<SubjectVO> courseCheck(){
		return SqlSession.selectList("co.fourth.tuna.domain.subject.mapper.SubjectMapper.SubjectCheck");
	}
	
	@ResponseBody
	@GetMapping("/stud/searchSubjectList")
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key) {
		return subjectDao.searchSubjectList(seasonCode, searchKey, key);
	}
	
	@ResponseBody
	@PostMapping("/professor/updateSubject")
	public ResponseEntity updateSubject(
			@RequestBody SubjectUpdateForm form) {
		
		String subjectResult = subjectDao.updateGradeRatio(form.getGradeRatio());
		String planResult = lecPlanService.updatePlanList(form.getPlans());
		
		List<String> resultMsg = new ArrayList<String>();
		
		resultMsg.add(subjectResult);
		resultMsg.add(planResult);
		
		return new ResponseEntity<>( resultMsg ,HttpStatus.OK);
	}
	
}
