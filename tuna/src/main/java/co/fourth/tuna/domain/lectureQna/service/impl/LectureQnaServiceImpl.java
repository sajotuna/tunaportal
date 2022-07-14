package co.fourth.tuna.domain.lectureQna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;

public class LectureQnaServiceImpl implements LectureQnaService {

	@Autowired
	LectureQnaMapper mapper;
	
	@Override
	public List<LectureQnaVO> qnaList(String key) {
		return null;
	}

	
	//mapper 주입, 오버라이딩
}
