package co.fourth.tuna.legacy.banner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BannerController {
	
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
