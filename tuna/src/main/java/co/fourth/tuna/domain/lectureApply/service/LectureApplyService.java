package co.fourth.tuna.domain.lectureApply.service;

import java.util.List;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

public interface LectureApplyService {
	public List<LectureApplyVO> SubjectFind(int pageNum, int size);
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo);
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo);
	public String FindApplyGrade(LectureApplyVO vo);
	public void CourseDelete(LectureApplyVO vo);
	public void CourseInsert(LectureApplyVO vo);
	public String ApplyErrorMsg(LectureApplyVO vo);
	public int subjectTarget(LectureApplyVO vo);
}
