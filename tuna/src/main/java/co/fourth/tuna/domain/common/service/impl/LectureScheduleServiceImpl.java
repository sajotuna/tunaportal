package co.fourth.tuna.domain.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.LectureScheduleMapper;
import co.fourth.tuna.domain.common.service.LectureScheduleService;
import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;

@Service
public class LectureScheduleServiceImpl implements LectureScheduleService {
	
	@Autowired LectureScheduleMapper map;
	
	@Override
	public List<LectureScheduleVO> findScheduleBySubjectId(int sbjno) {
		return map.findLectureScheduleForSubjectId(sbjno);
	}

}
