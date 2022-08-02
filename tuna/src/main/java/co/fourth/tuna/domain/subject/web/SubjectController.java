package co.fourth.tuna.domain.subject.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	@GetMapping("/stud/portal/searchSubjectList")
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key) {
		return subjectDao.searchSubjectList(seasonCode, searchKey, key);
	}
	
	@PostMapping("/staff/updateSubject")
	public ResponseEntity<String> updateSubject(
			@RequestBody SubjectUpdateForm form) {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE,
				"application/json;charset=UTF-8");
		String msg;
		try {
			msg = subjectDao.updateSubject(
					form.getGradeRatio(),
					form.getPlans());
		} catch (Error e) {
			return ResponseEntity.badRequest()
				.headers(resHeaders)
				.body(e.getMessage());
		} catch ( Exception e) {
			return ResponseEntity.badRequest()
				.headers(resHeaders)
				.body(e.getMessage());
		}
		
		return ResponseEntity.ok()
				.headers(resHeaders)
				.body(msg);
	}
	
}
