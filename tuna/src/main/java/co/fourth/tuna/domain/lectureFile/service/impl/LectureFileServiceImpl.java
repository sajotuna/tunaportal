package co.fourth.tuna.domain.lectureFile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureFile.mapper.LectureFileMapper;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

@Service
public class LectureFileServiceImpl implements LectureFileService {
	@Autowired LectureFileMapper map;
	
	@Override
	public String insertLectureFileByLectureFileVO(LectureFileVO vo) {
		if ( vo.getTitle().isBlank() ) {
			throw new Error("제목이 없습니다.");
		}
		if( map.insertLectureFileByLectureFileVO(vo) < 1 ) {
			throw new Error("업로드 실패");
		}
		
		return "업로드 성공";
	}

}
