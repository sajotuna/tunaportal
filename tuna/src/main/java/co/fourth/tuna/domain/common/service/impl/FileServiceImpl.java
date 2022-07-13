package co.fourth.tuna.domain.common.service.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import co.fourth.tuna.domain.common.service.FileService;

@Repository("file")
public class FileServiceImpl implements FileService {

	@Override
	public void upload() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String fileName, String folder) {
		
		String path = "C:\\Dev\\tunaportal\\tuna\\src\\main\\webapp\\WEB-INF\\files\\";
		String filePath = path + folder + "\\" + fileName;
		
		File file = new File(filePath);
		file.delete();

	}

}
