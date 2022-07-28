package co.fourth.tuna.domain.lectureQna.service;

import java.util.List;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface LectureQnaService {

	//질문단건조회
	public String qnaSelect(LectureQnaVO vo);
	
	//질문등록
	public void insertOneQna(LectureQnaVO vo);
	
	//질문삭제
	public void delOneQna(LectureQnaVO vo);
	
	//lectureQnaMapper과 동일한 메소드
//	List<LectureQnaVO> qnaList(String key);
	
	List<LectureQnaVO> findByProfessor(ProfessorVO vo, int pageNum, int size);
	
	List<LectureQnaVO> findListBySubjectId(int sbjno);
	
	List<LectureQnaVO> getListByStudentIdAndSubjectId(int stno, int sbjno);
}
