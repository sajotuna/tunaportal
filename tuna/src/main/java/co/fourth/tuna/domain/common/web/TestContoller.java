package co.fourth.tuna.domain.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
	public void singleTest(@RequestParam(value = "file")MultipartFile file, String text) {
		String[] fileInfo = fileService.upload(file, "test");
		logger.info("single :: originname " + fileInfo[0] + " :: filename " +fileInfo[1]);
		logger.info("single :: text " + text);
	}
	
	@RequestMapping("/dialogTest")
	public String dialogTest() {
		return "test/dialogTest";
	}
	
	//ckeditor5
	@RequestMapping("/ckTest")
	public String ckTest() {
		return "test/ckeditor5Test";
	}
	
	//CKEditor 이미지 업로드
	@RequestMapping("/ckeditorImage")
	@ResponseBody
	public Map<String, String> ckeditorImage(MultipartHttpServletRequest request)
			throws Exception {

		MultipartFile image = request.getFile("upload");
		Map<String, String> url = new HashMap<>();
		
		String[] fileInfo = fileService.upload(image, "test");
		url.put("url", fileInfo[1]);
		
		return url;
		
	}
	
	@PostMapping("/editorUpload")
	public String serverUpload(@RequestBody String editorContent) {
		logger.info("editorContent::" + editorContent);
		return "test/ckeditor5Test";
	}

	//CKEditor + ckFinder
	@RequestMapping("/ckFinderTest")
	public String ckFinderTest() {
		return "test/ckfinderTest";
	}
	
	//CKEditor 이미지 업로드
	@RequestMapping("/ckfinderImage")
	@ResponseBody
	public Map<String, String> ckfinderImage(MultipartHttpServletRequest request)
			throws Exception {
		MultipartFile image = request.getFile("upload");
		Map<String, String> result = new HashMap<>();
		
		String[] fileInfo = fileService.upload(image, "test");
		
		result.put("uploaded", "true");
		result.put("url", "display?fileName=" + fileInfo[1] + "&folder=test");
		
		return result;
		
	}
	
}
