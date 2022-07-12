package co.fourth.tuna.domain.lectureApply.service;

import java.util.List;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;

public interface LectureApplyService {
	public List<LectureApplyVO> SubjectFind();
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo);
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo);
}
