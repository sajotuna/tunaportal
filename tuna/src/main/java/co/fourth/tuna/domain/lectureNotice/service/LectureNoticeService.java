package co.fourth.tuna.domain.lectureNotice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface LectureNoticeService {
	// (학생)강의공지조회
	List<LectureNoticeVO> noticeList(LectureNoticeVO vo);

	// (학생)강의공지단건조회
	LectureNoticeVO noticeSelect(LectureNoticeVO vo);

	List<LectureNoticeVO> findByProfessor(@Param("prof") ProfessorVO prof, @Param("pageNum") int pageNum,
			@Param("size") int size);

	LectureNoticeVO findById(int no);
	List<LectureNoticeVO> findListBySubjectId(int sbjno);
}
