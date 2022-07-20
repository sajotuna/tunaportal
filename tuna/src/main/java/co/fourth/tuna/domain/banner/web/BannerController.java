package co.fourth.tuna.domain.banner.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;
import co.fourth.tuna.domain.common.service.FileService;

@RestController
public class BannerController {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired BannerService bannerDao;
	@Autowired FileService fileService;
	@Autowired String fileDir;
	
	// 슬라이드 배너 조회
	@RequestMapping("/sliderBanner")
	public List<BannerVO> sliderBanner(Model model) {
		return bannerDao.sliderBannerSelect();
	}
	
	// 옵션 배너 1건 조회
	@GetMapping("/optionBanner")
	public BannerVO optionBannerSelect() {
		return bannerDao.bannerSelect("1303");
	}
	
	// 기본 배너 1건 조회
	@GetMapping("/basicBanner")
	public BannerVO basicBannerSelect() {
		return bannerDao.bannerSelect("1302");
	}
	
	// 슬라이드 배너 순서 변경
	@PutMapping("/admin/sliderBanner")
	public int sliderBannerUpdate(@RequestBody BannerVO vo) {
		return bannerDao.sliderBannerUpdate(vo);
	}
	
	// 슬라이드 배너 등록
	@PostMapping("/admin/sliderBanner")
	public int sliderBannerInsert(@RequestParam(value = "file")MultipartFile file, BannerVO vo) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode("1301");
		
		return bannerDao.bannerInsert(vo);
	}
	
	// 배너 삭제
	@DeleteMapping("/admin/banner")
	public int bannerDelete(@RequestBody BannerVO vo) {
		
		fileService.delete(vo.getUri(), "banner");
		return bannerDao.bannerDelete(vo);
		
	}
	
	// 옵션 배너 등록
	@PostMapping("/admin/optionBanner")
	public int optionBannerInsert(BannerVO vo, @RequestParam(value = "file")MultipartFile file) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode("1303");
		
		return bannerDao.bannerInsert(vo);
	}
	
	// 기본 배너 등록
	@PostMapping("/admin/basicBanner")
	public int basicBannerInsert(BannerVO vo, @RequestParam(value = "file")MultipartFile file) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode("1302");
		
		return bannerDao.bannerInsert(vo);
	}
	
}
