package co.fourth.tuna.domain.lectureNotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;

import co.fourth.tuna.domain.user.vo.ProfessorVO;



public interface LectureNoticeMapper {

	//강의공지조회
	List<LectureNoticeVO> noticeList(LectureNoticeVO vo);
	//강의공지단건조회
	LectureNoticeVO noticeSelect(LectureNoticeVO vo);


	List<LectureNoticeVO> findByProfessor(
			@Param("prof")ProfessorVO vo, 
			@Param("pageNum")int pageNum, 
			@Param("size")int size);
	
	LectureNoticeVO findOneWithSubjectById(LectureNoticeVO vo);
	LectureNoticeVO findOneWithSubjectById(int id);
	List<LectureNoticeVO> findListBySubjectId(int sbjno);

}
