package co.fourth.tuna.domain.lectureEval.mapper;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.lectureEval.vo.LectureEvalVO;

public interface LectureEvalMapper {
	public void EvalSucess(LectureEvalVO vo);
	public List<Map<String,Object>> EvalAvgScore(String proNo);
	public List<Map<String,Object>> CourseEval(LectureEvalVO vo);
}
