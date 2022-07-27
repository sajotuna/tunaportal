package co.fourth.tuna.domain.lectureNotice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface LectureNoticeService {
	// (학생)강의공지조회
	public List<LectureNoticeVO> noticeList(LectureNoticeVO vo);

	// (학생)강의공지단건조회
	public LectureNoticeVO noticeSelect(LectureNoticeVO vo);

	public List<LectureNoticeVO> findByProfessor(@Param("prof") ProfessorVO prof, @Param("pageNum") int pageNum,
			@Param("size") int size);

	public LectureNoticeVO findById(int no);
	public List<LectureNoticeVO> findListBySubjectId(int sbjno);
	
	public String insertLectureNotice(LectureNoticeVO vo);
	public void noticeUpdate(LectureNoticeVO notice);
	public int noticeDelete(LectureNoticeVO notice);
}
