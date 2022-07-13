package co.fourth.tuna.domain.banner.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;
import co.fourth.tuna.domain.common.service.FileService;

@Controller
public class BannerController {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired BannerService bannerDao;
	@Autowired FileService fileService;
	@Autowired String fileDir;
	
	// 배너 전체 리스트
	@RequestMapping("/admin/bannerList")
	public String bannerList(Model model) {
		
		List<BannerVO> list = new ArrayList<>();
		list = bannerDao.bannerListSelect();
		
		model.addAttribute("bnList", list);
		
		return "banner/admin/bannerList";
		
	}
	
	// 배너 삭제
	@DeleteMapping("/admin/banner")
	@ResponseBody
	public int bannerDelete(@RequestBody BannerVO vo) {
		
		fileService.delete(vo.getUri(), "banner");
		return bannerDao.bannerDelete(vo);
		
	}
	
	// 옵션 배너 1건 조회
	@GetMapping("admin/optionBanner")
	@ResponseBody
	public BannerVO optionBannerSelect() {
		return bannerDao.bannerSelect("1303");
	}
	
	// 옵션 배너 등록
	@PostMapping("/admin/optionBanner")
	@ResponseBody
	public int optionBannerInsert(BannerVO vo, @RequestParam(value = "file")MultipartFile file, HttpServletRequest request) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode("1303");
		
		return bannerDao.bannerInsert(vo);
	}
	
	// 기본 배너 1건 조회
	@GetMapping("/admin/basicBanner")
	@ResponseBody
	public BannerVO basicBannerSelect() {
		return bannerDao.bannerSelect("1302");
	}
	
	// 기본 배너 등록
	@PostMapping("/admin/basicBanner")
	@ResponseBody
	public int basicBannerInsert(BannerVO vo, @RequestParam(value = "file")MultipartFile file, HttpServletRequest request) {
		
		String[] fileInfo = fileService.upload(file, "banner");
		
		vo.setFileName(fileInfo[0]);
		vo.setUri(fileInfo[1]);
		vo.setBannerCode("1302");
		
		return bannerDao.bannerInsert(vo);
	}
	
	// 페이지 맵핑
	@RequestMapping("/admin/basicBannerManagm")
	public String basicBannerManagm() {
		return "banner/admin/basicBannerManagm";
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
