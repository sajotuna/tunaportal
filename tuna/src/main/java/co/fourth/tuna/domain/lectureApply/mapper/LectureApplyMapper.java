package co.fourth.tuna.domain.lectureApply.mapper;

import java.util.ArrayList;
import java.util.List;

import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface LectureApplyMapper {
	public List<LectureApplyVO> SubjectFind(int pageNum, int size);
	public List<LectureApplyVO> CourseFind(List<LectureApplyVO> vo);
	public List<LectureApplyVO> CourseBasket(List<LectureApplyVO> vo);
	
	
	
	public ArrayList<LectureApplyVO> findBySubject(SubjectVO vo);
}
