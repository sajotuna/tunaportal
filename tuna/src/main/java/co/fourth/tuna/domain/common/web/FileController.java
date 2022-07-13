package co.fourth.tuna.domain.common.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @brief 파일 다운로드, 이미지 보여주기 맵핑
 * @author 지수빈
 * @date 2022/07/13
 * @details
 * 1. download() - 파일 다운로드
 *   Parameter : fileName(변환되어 저장된 파일명), originName(실제 파일명), folder(WEB-INF/files/* 폴더명)
 * 2. display() - 이미지 보여주기
 *   Parameter : fileName(변환되어 저장된 파일명), folder(WEB-INF/files/* 폴더명)
 */

@Controller
public class FileController {
	
	@Autowired String fileDir;
	
	// 파일 다운로드
	@RequestMapping("/download")
	public void download(
			@Param("fileName") String fileName,
			@Param("originName") String originName,
			@Param("folder") String folder, HttpServletResponse response) {
		
		String filePath = fileDir + folder + File.separator + fileName;
		
		try {
			
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\""
				+ URLEncoder.encode(originName, "UTF-8") + "\";");
		
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 이미지 파일 가져오기
	@RequestMapping("/display")
	public ResponseEntity<Resource> display(
			@Param("fileName") String fileName,
			@Param("folder") String folder) {
		
		String file = fileDir + folder + File.separator + fileName;
		
		Resource resource = new FileSystemResource(file);
		
		// 파일이 존재하지 않으면 404 error
		if(!resource.exists()) {
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

	
