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
	public String subjectTarget(LectureApplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.subjectTarget(vo);
	}

	@Override
	public List<Map<String, Object>> mySubjectList(LectureApplyVO vo) {
		return mapper.mySubjectList(vo);
	}

	@Override
	public void LectureApplySchedule(LectureApplyVO vo) {
		mapper.LectureApplySchedule(vo);
	}

	@Override
	public List<Map<String, Object>> SubjectFind(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return mapper.SubjectFind(params);
	}

	@Override
	public List<Map<String, Object>> CourseFind(LectureApplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.CourseFind(vo);
	}

	@Override
	public List<Map<String, Object>> CourseBasket(LectureBasketVO vo) {
		// TODO Auto-generated method stub
		return mapper.CourseBasket(vo);
	}

	@Override
	public List<Map<String, Object>> BasketSchedule(LectureBasketVO vo) {
		// TODO Auto-generated method stub
		return mapper.BasketSchedule(vo);
	}

	@Override
	public List<Map<String, Object>> CourseSchedule(LectureApplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.CourseSchedule(vo);
	}
	
	
}
