package co.fourth.tuna.domain.lectureFile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

public interface LectureFileMapper {
//	public LectureFileVO findById(int no);
//	public LectureFileVO findByVO(LectureFileVO vo);
	
	//자료실 목록 조회
	public List<LectureFileVO> lectureFileList(LectureFileVO vo);
	//단건강의 파일 조회
	public LectureFileVO  lectureFileDownload(LectureFileVO vo);
	
	public List<LectureFileVO> findListBySbjno(int sbjno);
	public int insertLectureFileByLectureFileVO(
			@Param(value="lectureFile")LectureFileVO vo);
	public int deleteLectureFileByLectureFileId(int no);
}
