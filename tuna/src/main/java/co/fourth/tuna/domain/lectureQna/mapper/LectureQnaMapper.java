package co.fourth.tuna.domain.lectureQna.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface LectureQnaMapper {

	//질문목록
	
	//질문단건조회
	
	//질문에 대한 댓글 조회?
	
	//질문작성
	

	// ckw 서브젝트로 목록 조회
	public ArrayList<LectureQnaVO> findBySubject(SubjectVO vo);
	
	public List<LectureQnaVO> findListWithSubjectAndStudentByProfessor(
			@Param("prof")ProfessorVO vo, 
			@Param("pageNum")int pageNum, 
			@Param("size")int size
		);
}
