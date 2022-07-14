package co.fourth.tuna.domain.lectureNotice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;

public class LectureNoticeServiceImpl implements LectureNoticeService {

	@Autowired LectureNoticeMapper map;
	
	@Override
	public List<LectureNoticeVO> noticeList(int state, String key) {
		return map.noticeList(state, key);
	}

	@Override
	public LectureNoticeVO noticeSelect(LectureNoticeVO vo) {
		return map.noticeSelect(vo);
	}

}
