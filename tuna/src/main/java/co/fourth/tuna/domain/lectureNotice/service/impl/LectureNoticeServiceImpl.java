package co.fourth.tuna.domain.lectureNotice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Service
public class LectureNoticeServiceImpl implements LectureNoticeService {

	@Autowired LectureNoticeMapper map;
	
	@Override
	public List<LectureNoticeVO> noticeList(LectureNoticeVO vo) {
		return map.noticeList(vo);
	}

	@Override
	public LectureNoticeVO noticeSelect(LectureNoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public List<LectureNoticeVO> findByProfessor(ProfessorVO prof, int pageNum, int size) {
		return map.findByProfessor(prof, pageNum, size);
	}

	@Override
	public LectureNoticeVO findById(int no) {
		return map.findOneWithSubjectById(no);
	}

	@Override
	public List<LectureNoticeVO> findListBySubjectId(int sbjno) {
		return map.findListBySubjectId(sbjno);
	}

	@Override
	public String insertLectureNotice(LectureNoticeVO vo) {
		if(map.insertOneByLectureNoticeVO(vo) < 1) {
			return "실패";
		}
		
		return "성공";
	}

	@Override
	public void noticeUpdate(LectureNoticeVO notice) {
		map.noticeUpdate(notice);
		
	}

	@Override
	public int noticeDelete(LectureNoticeVO notice) {
		return map.noticeDelete(notice);
		
	}



}
