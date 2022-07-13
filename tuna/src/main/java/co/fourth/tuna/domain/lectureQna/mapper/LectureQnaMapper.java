package co.fourth.tuna.domain.lectureQna.mapper;

import java.util.ArrayList;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureQnaMapper {

	//질문목록
	
	//질문단건조회
	
	//질문에 대한 댓글 조회?
	
	//질문작성
	

	// ckw 서브젝트로 목록 조회
	public ArrayList<LectureQnaVO> findBySubject(SubjectVO vo);
}
