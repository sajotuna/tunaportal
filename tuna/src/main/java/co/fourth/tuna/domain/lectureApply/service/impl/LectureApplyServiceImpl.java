package co.fourth.tuna.domain.lectureApply.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper;
import co.fourth.tuna.domain.lectureApply.service.LectureApplyService;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

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
	public String ApplyErrorMsg(LectureApplyVO vo) {
		return mapper.ApplyErrorMsg(vo);
	}

	@Override
	public void CourseDelete(LectureApplyVO vo) {
		mapper.CourseDelete(vo);
		
	}

	@Override
	public int subjectTarget(LectureApplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.subjectTarget(vo);
	}

	@Override
	public List<Map<String, Object>> mySubjectList(LectureApplyVO vo) {
		return mapper.mySubjectList(vo);
	}
	
	
}
