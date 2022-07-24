package co.fourth.tuna.domain.lectureEval.web;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.lectureEval.service.LectureEvalService;
import co.fourth.tuna.domain.lectureEval.vo.LectureEvalVO;

@Controller
public class LectureEvalController {

	@Autowired
	private SqlSession SqlSession;
	
	@Autowired
	private LectureEvalService evalDao;
	
	
	@RequestMapping("/stud/course/Evaluation")
	public String lectureEvaluation() {
		return "course/evaluation/lectureEvaluation";
	}
	
	
	@RequestMapping("/stud/course/Details")
	public String lectureEvaluationDetails(LectureEvalVO vo, Model model, Authentication authentication) {
		
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureEval.mapper.LectureEvalMapper.CourseEval", vo);
		model.addAttribute("list", lists);
		return "course/evaluation/lectureEvaluationDetails";
	}
	
	
	
	@RequestMapping("/stud/course/Search")
	public String lectureEvaluationSearch(String proNo, Model model) {
		
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureEval.mapper.LectureEvalMapper.EvalAvgScore",proNo);
		model.addAttribute("list", lists);
		return "course/evaluation/lectureEvaluationSearch";
	}

	@RequestMapping("/stud/course/evalSuccess")
	public String lectureEval(Authentication authentication, LectureEvalVO vo) {
		vo.setEvalState("y");
		vo.setStNo(authentication.getName());
		System.out.println(vo);
		
		evalDao.EvalSucess(vo);
		
		return "close";
	}
	
	// 강의 계획서 조회 - 강의 평가 모달
	@RequestMapping("/portal/student/lectureEvaluation")
	@ResponseBody
	public List<Map<String,Object>> portalLectureEvaluation(LectureEvalVO vo, Model model, Authentication authentication) {
		
		vo.setStNo(authentication.getName());
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.lectureEval.mapper.LectureEvalMapper.EvalAvgScore", vo);
		return lists;
	}

}
