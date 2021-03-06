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
	public String qnaList(
			@Param("vo")LectureQnaVO vo, 
			@Param("pageNum")int pageNum, 
			@Param("size")int size);

	//질문단건조회
	public String qnaSelect(LectureQnaVO vo);
	
	//질문작성
	public void insertOneQna(LectureQnaVO vo);
	//질문삭제
	public void delOneQna(LectureQnaVO vo);

	//페이지네이션
	public int lectureQnaPagingCount(LectureQnaVO vo);
	

	// ckw 서브젝트로 목록 조회
	public ArrayList<LectureQnaVO> findBySubjectId(@Param(value = "no") int no);
	
	public List<LectureQnaVO> findListWithSubjectAndStudentByProfessor(
			@Param("prof")ProfessorVO vo, 
			@Param("pageNum")int pageNum, 
			@Param("size")int size
		);
	
	public List<LectureQnaVO> findListBySubjectId(int sbjno);
	
	public List<LectureQnaVO> selectListByStudentIdAndSubjectId(
			@Param("stno")int stno, 
			@Param("sbjno")int sbjno);
	

	public LectureQnaVO selectOneByLectureQnaId(int qnano);

	//교수qna 한건조회
	public LectureQnaVO professorFindQna(LectureQnaVO vo);
	//교수 답안 작성
	public void professorQnaUpdate(LectureQnaVO vo);
	
}
