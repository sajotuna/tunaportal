package co.fourth.tuna.domain.lectureFile.service.impl;


import co.fourth.tuna.domain.common.service.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.fourth.tuna.domain.lectureFile.mapper.LectureFileMapper;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

@Service
public class LectureFileServiceImpl implements LectureFileService {
	@Autowired LectureFileMapper map;
	@Autowired FileService fileService;
	
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

	@Override
	public String deleteLecturefileByLectureFileVO(LectureFileVO vo) throws Error {
		if ( map.deleteLectureFileByLectureFileId(vo.getNo()) < 1 ) {
			throw new Error("삭제 실패");
		}
		fileService.delete(vo.getUri(), "LectureFile");
		
		return "삭제 성공";
	}

	@Autowired LectureFileMapper map;
	
	@Override
	public LectureFileVO lectureFileList(LectureFileVO vo) {
		return map.lectureFileList(vo);
	}

	@Override
	public List<LectureFileVO> lectureFileDownload(LectureFileVO vo) {
		return map.lectureFileDownload(vo);
	}

	
}
