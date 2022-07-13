package co.fourth.tuna.domain.banner.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;

@Controller
public class BannerController {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired BannerService bannerDao;
	
	@RequestMapping("/admin/basicBannerManagm")
	public String basicBannerManagm() {
		return "banner/admin/basicBannerManagm";
	}
	
	// 기본 배너 1건 조회
	@GetMapping("/admin/basicBanner")
	@ResponseBody
	public BannerVO basicBannerSelect() {
		return bannerDao.bannerSelect("1302");
	}
	
	@Autowired String fileDir;
	
	// 기본 배너 등록
	@PostMapping("/admin/basicBanner")
	@ResponseBody
	public int basicBannerInsert(BannerVO vo, @RequestParam(value = "file")MultipartFile file, HttpServletRequest request) {
		
		String saveDir = fileDir + File.separator + "banner";
		File dir = new File(saveDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String uid = UUID.randomUUID().toString();
		String saveFileName = uid + fileName.substring(fileName.indexOf("."));
		
		File target = new File(saveDir,saveFileName);
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		vo.setFileName(fileName);
		vo.setUri(saveFileName);
		vo.setBannerCode("1302");
		
		return bannerDao.bannerInsert(vo);
	}
	
	@RequestMapping("/admin/optionBannerManagm")
	public String optionBannerManagm() {
		return "banner/admin/optionBannerManagm";
	}
	
	@RequestMapping("/admin/sliderBannerManagm")
	public String sliderBannerManagm() {
		return "banner/admin/sliderBannerManagm";
	}
	
}
