package co.fourth.tuna.web.portal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;

@Controller
public class PortalController {
	
	@Autowired BannerService bannerDao;

	// 배너 리스트
	@GetMapping("homeSliderBanner")
	public String bannerList(Model model) {
		
		List<BannerVO> list = new ArrayList<>();
		list = bannerDao.bannerListSelect();
		
		model.addAttribute("bnList", list);
		
		return "portal/main/sliderBanner";
		
	}
	
}
