package co.fourth.tuna.domain.banner.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired BannerService bannerDao;
	@Autowired FileService fileService;
	
	// 슬라이드 배너 조회
	@RequestMapping("/{user}/banner/sliderBanner")
	public List<BannerVO> sliderBannerSelect(@PathVariable String user, Model model) {
		return bannerDao.sliderBannerSelect();
	}
	
	// 기본, 옵션 배너 1건 조회
	@GetMapping("/{user}/banner/{bannerCode}")
	public BannerVO bannerSelect(@PathVariable String user, @PathVariable String bannerCode) {
			return bannerDao.bannerSelect(bannerCode);	
	}
	
	// 슬라이드 배너 순서 변경
	@PutMapping("/admin/admin/banner")
	public int sliderBannerUpdate(@RequestBody BannerVO vo) {
		return bannerDao.sliderBannerUpdate(vo);
	}
	
	// 배너 등록
	@PostMapping("/admin/admin/banner/{bannerCode}")
	public int bannerInsert(@PathVariable String bannerCode, @RequestParam(value = "file")MultipartFile file, BannerVO vo) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode(bannerCode);
		
		return bannerDao.bannerInsert(vo);
	}
	
	// 배너 삭제
	@DeleteMapping("/admin/admin/banner")
	public int bannerDelete(@RequestBody BannerVO vo) {
		
		fileService.delete(vo.getUri(), "banner");
		return bannerDao.bannerDelete(vo);
		
	}
	
}
