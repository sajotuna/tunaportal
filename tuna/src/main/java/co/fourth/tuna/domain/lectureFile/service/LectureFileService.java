package co.fourth.tuna.domain.lectureFile.service;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;
import java.util.List;

public interface LectureFileService {
	public String insertLectureFileByLectureFileVO(LectureFileVO vo);
	public String deleteLecturefileByLectureFileVO(LectureFileVO vo);

	//자료실 목록 조회
	public List<LectureFileVO> lectureFileList(LectureFileVO vo);
	//단건강의 파일 조회
	public LectureFileVO lectureFileDownload(LectureFileVO vo);
	
}
