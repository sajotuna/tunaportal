package co.fourth.tuna.domain.lectureApply.mapper;

import java.util.List;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;

public interface LectureApplyMapper {
	public List<LectureApplyVO> SubjectFind(int pageNum, int size);
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo);
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo);
}
