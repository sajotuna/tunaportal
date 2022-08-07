package co.fourth.tuna.domain.lectureFile.service.impl;


import co.fourth.tuna.domain.common.service.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.fourth.tuna.domain.lectureFile.mapper.LectureFileMapper;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;
import co.fourth.tuna.util.ResMsgService;
import co.fourth.tuna.util.ResponseMsg;

@Service
public class LectureFileServiceImpl implements LectureFileService {
	@Autowired LectureFileMapper map;
	@Autowired FileService fileService;
	@Autowired ResMsgService msgService;
	
	@Override
	public ResponseMsg insertLectureFileByLectureFileVO(LectureFileVO vo) {
		ResponseMsg res = msgService.build(
				"title.suc.upload", 
				new String[]{"msg.suc.enroll","강의자료"},
				ResponseMsg.SUCCESS);
		if ( vo.getTitle().isBlank() ) {
			return msgService.build(
					"title.err.enroll",
					new String[]{"msg.err.inputPlz","제목"},
					ResponseMsg.ERROR);
		}
		if( map.insertLectureFileByLectureFileVO(vo) < 1 ) {
			return msgService.build(
				"title.err.enroll",
				new String[]{"msg.err.fail","강의자료 등록"},
				ResponseMsg.ERROR);
		}
		
		return res;
	}

	@Override
	public ResponseMsg deleteLecturefileByLectureFileVO(LectureFileVO vo) {
		ResponseMsg res = msgService.build(
				"title.suc.delete", 
				new String[]{"msg.suc.delete","강의자료"},
				ResponseMsg.SUCCESS);
		
		if ( map.deleteLectureFileByLectureFileId(vo.getNo()) < 1 ) {
			return msgService.build(
					"title.err.enroll",
					new String[]{"msg.err.fail","강의자료 삭제"},
					ResponseMsg.ERROR);
		}
		fileService.delete(vo.getUri(), "LectureFile");
		
		return res;
	}
	
	@Override
	public List<LectureFileVO> lectureFileList(LectureFileVO vo) {
		return map.lectureFileList(vo);
	}

	@Override
	public LectureFileVO lectureFileDownload(LectureFileVO vo) {
		return map.lectureFileDownload(vo);
	}

	
}
