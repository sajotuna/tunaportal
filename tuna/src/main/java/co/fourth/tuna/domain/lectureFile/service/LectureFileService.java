package co.fourth.tuna.domain.lectureFile.service;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

public interface LectureFileService {
	public String insertLectureFileByLectureFileVO(LectureFileVO vo);
	public String deleteLecturefileByLectureFileVO(LectureFileVO vo);
}
