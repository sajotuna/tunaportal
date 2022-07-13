package co.fourth.tuna.domain.common.web;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FileController {
	
	// 파일 업로드
	public static void upload() {
		
	}
	
	// 파일 다운로드
	@RequestMapping("/download")
	public static void download() {
		
	}
	
	// 이미지 파일 가져오기
	@GetMapping("/display")
	public ResponseEntity<Resource> display(
			@Param("filename") String fileName,
			@Param("folder") String folder) {
		String path = "C:\\Users\\admin\\git\\tunaportal\\tuna\\src\\main\\webapp\\WEB-INF\\files\\";
		String file = path + folder + "\\" + fileName;
		Resource resource = new FileSystemResource(file);
		
		if(! resource.exists()) {
			// 파일이 존재하지 않으면 404 error
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
			
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		
		try {
			
			filePath = Paths.get(file);
			header.add("Content-Type", Files.probeContentType(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		
	}
	
	// 삭제
	public static void delete() {
		
	}
	
}

	
