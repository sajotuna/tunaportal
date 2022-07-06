package co.fourth.tuna.banner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BannerController {
	
	@RequestMapping("basicBannerManagm")
	public String basicBannerManagm() {
		return "portal/admin/basicBannerManagm";
	}
	
	@RequestMapping("optionBannerManagm")
	public String optionBannerManagm() {
		return "portal/admin/optionBannerManagm";
	}
	
	@RequestMapping("sliderBannerManagm")
	public String sliderBannerManagm() {
		return "portal/admin/sliderBannerManagm";
	}
	
}
