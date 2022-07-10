package co.fourth.tuna.domain.lectureApply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper;
import co.fourth.tuna.domain.lectureApply.service.LectureApplyService;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;

@Service
public class LectureApplyServiceImpl implements LectureApplyService {

	@Autowired
	private LectureApplyMapper mapper;
	
	@Override
	public List<LectureApplyVO> SubjectFind() {
		// TODO Auto-generated method stub
		return mapper.SubjectFind();
	}

}
