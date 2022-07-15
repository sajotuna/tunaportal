package co.fourth.tuna.web.portal.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;

@Controller
public class PortalAdminController {
	
	@Autowired
	BannerService bannerDao;

	// 배너 리스트
	@GetMapping("/admin/bannerList")
	public String bannerList(Model model) {
		
		List<BannerVO> list = new ArrayList<>();
		list = bannerDao.bannerListSelect();
		
		model.addAttribute("bnList", list);
		
		return "banner/admin/bannerList";
		
	}
	
	// 기본 배너
	@RequestMapping("/admin/basicBannerManagm")
	public String basicBannerManagm() {
		return "banner/admin/basicBannerManagm";
	}
	
	// 옵션 배너
	@RequestMapping("/admin/optionBannerManagm")
	public String optionBannerManagm() {
		return "banner/admin/optionBannerManagm";
	}
	
	// 슬라이드 배너
	@RequestMapping("/admin/sliderBannerManagm")
	public String sliderBannerManagm(Model model) {
		model.addAttribute("bnList", bannerDao.sliderBannerSelect());
		return "banner/admin/sliderBannerManagm";
	}
	
}
