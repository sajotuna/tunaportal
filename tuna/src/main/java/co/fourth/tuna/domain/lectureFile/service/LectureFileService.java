package co.fourth.tuna.domain.lectureFile.service;

import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

public interface LectureFileService {
	public String insertLectureFileByLectureFileVO(LectureFileVO vo);
}
