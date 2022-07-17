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
	public List<LectureApplyVO> SubjectFind(int pageNum, int size) {
		// TODO Auto-generated method stub
		return mapper.SubjectFind(pageNum, size);
	}

	@Override
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo) {
		// TODO Auto-generated method stub
		return mapper.CourseFind(vo);
	}

	@Override
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo) {
		// TODO Auto-generated method stub
		return mapper.CourseBasket(vo);
	}

	@Override
	public String FindApplyGrade(LectureApplyVO vo) {
		return mapper.FindApplyGrade(vo);
	}

	@Override
	public void CourseInsert(LectureApplyVO vo) {
		mapper.CourseInsert(vo);
		
	}

	@Override
	public List<LectureApplyVO> mySubjectList(LectureApplyVO vo) {
		return mapper.mySubjectList(vo);
	}

}
