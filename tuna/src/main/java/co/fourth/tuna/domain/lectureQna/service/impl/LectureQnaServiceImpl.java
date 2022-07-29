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
	
//	@Override
//	public List<LectureQnaVO> qnaList(String key) {
//		return null;
//	}

	@Override
	public List<LectureQnaVO> findByProfessor(ProfessorVO prof, int pageNum, int size) {
		return mapper.findListWithSubjectAndStudentByProfessor(prof, pageNum, size);
		
	}

	//학생 질문 단건 조회
	@Override
	public String qnaSelect(LectureQnaVO vo) {
		return mapper.qnaSelect(vo);
	}

	@Override
	public List<LectureQnaVO> findListBySubjectId(int sbjno) {
		return mapper.findListBySubjectId(sbjno);
	}

	@Override
	public void insertOneQna(LectureQnaVO vo) {
		 mapper.insertOneQna(vo);
	}

	@Override
	public void delOneQna(LectureQnaVO vo) {
		mapper.delOneQna(vo);
	}


	@Override
	public List<LectureQnaVO> getListByStudentIdAndSubjectId(
				int stno, int sbjno) {
		return mapper.selectListByStudentIdAndSubjectId(stno, sbjno);
}

	@Override
	public int lectureQnaPagingCount(LectureQnaVO vo) {
		return mapper.lectureQnaPagingCount(vo);
	}

	
	//mapper 주입, 오버라이딩
}
