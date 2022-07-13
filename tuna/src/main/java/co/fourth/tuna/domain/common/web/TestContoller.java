package co.fourth.tuna.domain.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.common.service.FileService;


@Controller
public class TestContoller {
	
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
		fileService.upload(files, "test");
	}
	
	//sing file test
	@RequestMapping("/admin/singleTest")
	@ResponseBody
	public void singleTest(@RequestParam(value = "file")MultipartFile[] file) {
		fileService.upload(file, "test");
	}
	
}
