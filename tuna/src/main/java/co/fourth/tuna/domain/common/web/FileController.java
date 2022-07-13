package co.fourth.tuna.domain.common.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

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
	
	// 파일 다운로드
	@RequestMapping("/download")
	public static void download(
			@Param("fileName") String fileName,
			@Param("originName") String originName,
			@Param("folder") String folder, HttpServletResponse response) {
		
		String path = "C:\\Dev\\tunaportal\\tuna\\src\\main\\webapp\\WEB-INF\\files\\";
		String filePath = path + folder + "\\" + fileName;
		
		try {
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath));
			
			// 모든 타입의 데이터를 전송
			response.setContentType("application/octet-stream");
			// 파일 길이만큼 사이즈 설정
			response.setContentLength(fileByte.length);
			// 파일을 다운받기 위한 설정으로, 업로드 시 실제 파일명으로 다운받을 수 있도록 한다.
			response.setHeader("Content-Disposition", "attachment; fileName=\""
				+ URLEncoder.encode(originName, "UTF-8") + "\";");
		
			// 입출력 스트림
			response.getOutputStream().write(fileByte);	// 파일 저장
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 이미지 파일 가져오기
	@GetMapping("/display")
	public ResponseEntity<Resource> display(
			@Param("fileName") String fileName,
			@Param("folder") String folder) {
		String path = "C:\\Dev\\tunaportal\\tuna\\src\\main\\webapp\\WEB-INF\\files\\";
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
	
}

	
