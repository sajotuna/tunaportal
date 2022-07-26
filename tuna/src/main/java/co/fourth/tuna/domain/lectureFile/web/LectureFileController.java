package co.fourth.tuna.domain.lectureFile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.lectureFile.service.LectureFileService;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;

@Controller
public class LectureFileController {
	
	@Autowired FileService fileService;
	@Autowired LectureFileService lectureFileService;
	
	@PostMapping("/staff/insertSubjectFile")
	public ResponseEntity<String> insertLectureFile(
			@RequestParam(value = "file")MultipartFile file,
			LectureFileVO filevo) {
		ResponseEntity<String> res = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		try {
			String[] fileInfo = fileService.upload(file, "lectureFile");
			filevo.setFileName(fileInfo[0]);
			filevo.setUri(fileInfo[1]);
			
			res = new ResponseEntity<String>(
					lectureFileService.insertLectureFileByLectureFileVO(filevo),
					headers,
					HttpStatus.OK);
					
		} catch ( Throwable e) {
			res = new ResponseEntity<String>(
					e.getMessage(),
					headers,
					HttpStatus.BAD_REQUEST);
		}
		
		return res;
	}
	
	@PostMapping("/staff/deleteSubjectFile")
	public ResponseEntity<String> deleteLectureFile(LectureFileVO file) {
		ResponseEntity<String> res = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		try {
			res = new ResponseEntity<String>(
					lectureFileService.deleteLecturefileByLectureFileVO(file),
					headers,
					HttpStatus.OK);
		} catch( Throwable e ) {
			res = new ResponseEntity<String>(
					e.getMessage(),
					headers,
					HttpStatus.BAD_REQUEST);
		}
		
		return res;
	}
	
}
