package co.fourth.tuna.domain.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String[] upload(MultipartFile[] files, String folder);
	public void delete(String fileName, String folder);
	
}
