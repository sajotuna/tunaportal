package co.fourth.tuna.domain.lectureQna.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Service
public class LectureQnaServiceImpl implements LectureQnaService {

	@Autowired
	LectureQnaMapper mapper;
	
	@Override
	public List<LectureQnaVO> qnaList(String key) {
		return null;
	}

	@Override
	public List<LectureQnaVO> findByProfessor(ProfessorVO prof, int pageNum, int size) {
		return mapper.findByProfessor(prof, pageNum, size);
		
	}

	
	//mapper 주입, 오버라이딩
}
