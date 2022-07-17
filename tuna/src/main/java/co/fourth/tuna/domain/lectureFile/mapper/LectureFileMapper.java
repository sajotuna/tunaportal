package co.fourth.tuna.domain.lectureFile.mapper;

import java.util.List;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

public interface LectureFileMapper {
//	public LectureFileVO findById(int no);
//	public LectureFileVO findByVO(LectureFileVO vo);
	
	public List<LectureFileVO> findListBySbjno(int sbjno);
}
