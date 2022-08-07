package co.fourth.tuna.domain.lectureFile.service;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;
import co.fourth.tuna.util.ResponseMsg;

import java.util.List;

public interface LectureFileService {
	public ResponseMsg insertLectureFileByLectureFileVO(LectureFileVO vo);
	public ResponseMsg deleteLecturefileByLectureFileVO(LectureFileVO vo);

	//자료실 목록 조회
	public List<LectureFileVO> lectureFileList(LectureFileVO vo);
	//단건강의 파일 조회
	public LectureFileVO lectureFileDownload(LectureFileVO vo);
	
}
