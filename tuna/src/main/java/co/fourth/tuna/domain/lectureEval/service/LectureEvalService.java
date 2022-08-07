package co.fourth.tuna.domain.lectureEval.service;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.lectureEval.vo.LectureEvalVO;

public interface LectureEvalService {

	public void EvalSucess(LectureEvalVO vo);
	public List<Map<String,Object>> EvalAvgScore(String proNo);
	public List<Map<String,Object>> CourseEval(LectureEvalVO vo);
}
