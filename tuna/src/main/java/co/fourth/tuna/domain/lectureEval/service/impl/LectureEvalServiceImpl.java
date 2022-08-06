package co.fourth.tuna.domain.lectureEval.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureEval.mapper.LectureEvalMapper;
import co.fourth.tuna.domain.lectureEval.service.LectureEvalService;
import co.fourth.tuna.domain.lectureEval.vo.LectureEvalVO;

@Service
public class LectureEvalServiceImpl implements LectureEvalService {

	@Autowired 
	private LectureEvalMapper mapper;
	
	@Override
	public void EvalSucess(LectureEvalVO vo) {
		mapper.EvalSucess(vo);
	}
	@Override
	public List<Map<String, Object>> EvalAvgScore(String proNo) {
		return mapper.EvalAvgScore(proNo);
	}

	@Override
	public List<Map<String, Object>> CourseEval(LectureEvalVO vo) {
		return mapper.CourseEval(vo);
	}

}
