package co.fourth.tuna.domain.lectureApply.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureApplyMapper {
	public List<Map<String,Object>> SubjectFind(Map<String, Object> params);
	public List<Map<String,Object>> CourseFind(LectureApplyVO vo);
	public List<Map<String,Object>> CourseBasket(LectureBasketVO vo);
	public List<Map<String,Object>> BasketSchedule(LectureBasketVO vo);
	public List<Map<String,Object>> CourseSchedule(LectureApplyVO vo);
	public void CourseDelete(LectureApplyVO vo);
	public String FindApplyGrade(LectureApplyVO vo);
	public void CourseInsert(LectureApplyVO vo);
	public String ApplyErrorMsg(LectureApplyVO vo);
	public ArrayList<LectureApplyVO> findBySubject(SubjectVO vo);
	public String subjectTarget(LectureApplyVO vo);
	public void LectureApplySchedule(LectureApplyVO vo);
	public List<Map<String, Object>> mySubjectList(LectureApplyVO vo);
	
}
