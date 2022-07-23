package co.fourth.tuna.domain.subject.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectUpdateForm;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.util.ResState;
import co.fourth.tuna.util.ServiceResponseVO;


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
	@Transactional
	@PostMapping("/professor/updateSubject")
	public ResponseEntity updateSubject(
			@RequestBody SubjectUpdateForm form) {
		
		ServiceResponseVO planResult = lecPlanService.updatePlanList(form.getPlans());
		if(planResult.getState() == ResState.ERROR) {
			return new ResponseEntity<>( planResult.getMessage(), HttpStatus.BAD_REQUEST );
		}
		
		ServiceResponseVO subjectResult = subjectDao.updateGradeRatio(form.getGradeRatio());
		if(subjectResult.getState() == ResState.ERROR) {
			return new ResponseEntity<>( subjectResult.getMessage(), HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( "성공" ,HttpStatus.OK);
	}
	
}
