package co.fourth.tuna.domain.banner.service;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerService {

	BannerVO bannerSelect(String bannerCode);
	int bannerInsert(BannerVO vo);
	int sliderBannerInsert(BannerVO vo);
	int sliderBannerDelete(BannerVO vo);
	
}
