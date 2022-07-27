package co.fourth.tuna.domain.lectureNotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;



public interface LectureNoticeMapper {

	//강의공지조회
	public List<LectureNoticeVO> noticeList(LectureNoticeVO vo);
	//강의공지단건조회
	public LectureNoticeVO noticeSelect(LectureNoticeVO vo);


	public List<LectureNoticeVO> findByProfessor(
			@Param("prof")ProfessorVO vo, 
			@Param("pageNum")int pageNum, 
			@Param("size")int size);
	
	public LectureNoticeVO findOneWithSubjectById(LectureNoticeVO vo);
	public LectureNoticeVO findOneWithSubjectById(int id);
	public List<LectureNoticeVO> findListBySubjectId(int sbjno);
	
	public int insertOneByLectureNoticeVO(
			@Param("notice")LectureNoticeVO notice);
	public void noticeUpdate(LectureNoticeVO notice);
	public int noticeDelete(LectureNoticeVO notice);
}
