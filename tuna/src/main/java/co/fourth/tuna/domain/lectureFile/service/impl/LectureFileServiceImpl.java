package co.fourth.tuna.domain.lectureFile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureFile.mapper.LectureFileMapper;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

@Service
public class LectureFileServiceImpl implements LectureFileService {

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
