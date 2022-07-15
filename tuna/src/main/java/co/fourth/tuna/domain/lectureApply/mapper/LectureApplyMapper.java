package co.fourth.tuna.domain.lectureApply.mapper;

import java.util.ArrayList;
import java.util.List;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureApplyMapper {
	public List<LectureApplyVO> SubjectFind(int pageNum, int size);
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo);
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo);
	public void CourseDelete(LectureApplyVO vo);
	public String FindApplyGrade(LectureApplyVO vo);
	public void CourseInsert(LectureApplyVO vo);
	public String ApplyErrorMsg(LectureApplyVO vo);
	public ArrayList<LectureApplyVO> findBySubject(SubjectVO vo);
	public int subjectTarget(LectureApplyVO vo);
}
