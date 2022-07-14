package co.fourth.tuna.domain.lectureQna.service;

import java.util.List;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface LectureQnaService {

	//lectureQnaMapper과 동일한 메소드
	List<LectureQnaVO> qnaList(String key);
	
	List<LectureQnaVO> findByProfessor(ProfessorVO vo, int pageNum, int size);
}
