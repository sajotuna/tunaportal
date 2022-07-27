package co.fourth.tuna.domain.lectureFile.service;

import java.util.List;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

public interface LectureFileService {

	//자료실 목록 조회
	public LectureFileVO lectureFileList(LectureFileVO vo);
	//단건강의 파일 조회
	public List<LectureFileVO> lectureFileDownload(LectureFileVO vo);
	
}
