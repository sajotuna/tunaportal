package co.fourth.tuna.domain.lectureEval.service.impl;

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

}
