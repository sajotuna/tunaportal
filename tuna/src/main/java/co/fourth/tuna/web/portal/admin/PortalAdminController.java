package co.fourth.tuna.web.portal.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerPagingVO;
import co.fourth.tuna.domain.banner.vo.BannerVO;
import co.fourth.tuna.domain.common.service.PagingService;
import co.fourth.tuna.domain.common.vo.PagingVO;

@Controller
public class PortalAdminController {
	
	private static Logger logger = LoggerFactory.getLogger(PortalAdminController.class); 
	
	@Autowired
	BannerService bannerDao;
	@Autowired
	PagingService pagingDao;

	// 배너 리스트
	@GetMapping("/admin/bannerList")
	public String bannerList(Model model, 
			 
			@RequestParam(required = false, defaultValue = "1") int page,
			                 @RequestParam(required = false, defaultValue = "1") int range) {
		
		BannerPagingVO bvo = new BannerPagingVO(10);
		
		PagingVO pvo = pagingDao.getPaging(new PagingVO("banner", bvo.getListSize()));
		
		bvo.pageInfo(page, range, pvo.getPageCount(), 5);
		
		List<BannerVO> list = bannerDao.bannerListSelect(bvo.getStartList(), bvo.getEndList());
		
		logger.info("start::"+bvo.getStartList()+"end::"+bvo.getEndList()
		+"startpage::"+bvo.getStartPage()+"endpage::"
				+bvo.getEndPage()+"pagecount::"+bvo.getPageCnt());
		
		model.addAttribute("bnList", list);
		model.addAttribute("paging", bvo);
		
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
