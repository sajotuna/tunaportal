package co.fourth.tuna.domain.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.banner.web.BannerController;
import co.fourth.tuna.domain.common.service.FileService;


@Controller
public class TestContoller {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired FileService fileService;
	@Autowired String fileDir;
	
	@RequestMapping("/admin/fileTest")
	public String fileTest(Model model) {
		return "test/fileTest";
	}
	
	//multiple file test
	@RequestMapping("/admin/multiTest")
	@ResponseBody
	public void multiTest(@RequestParam(value = "file[]")MultipartFile[] files) {
		for (MultipartFile file : files) {
			String[] fileInfo = fileService.upload(file, "test");
			logger.info("multiple :: originname " + fileInfo[0] + " :: filename " +fileInfo[1]);
		}
	}
	
	//single file test
	@RequestMapping("/admin/singleTest")
	@ResponseBody
	public void singleTest(@RequestParam(value = "file")MultipartFile file) {
		String[] fileInfo = fileService.upload(file, "test");
		logger.info("single :: originname " + fileInfo[0] + " :: filename " +fileInfo[1]);
	}
	
	@RequestMapping("/dialogTest")
	public String dialogTest() {
		return "test/dialogTest";
	}
}
