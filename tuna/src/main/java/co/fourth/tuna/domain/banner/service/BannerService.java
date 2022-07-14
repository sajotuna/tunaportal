package co.fourth.tuna.domain.banner.service;

import java.util.List;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerService {

	List<BannerVO> bannerListSelect();
	BannerVO bannerSelect(String bannerCode);
	int bannerDelete(BannerVO vo);
	int bannerInsert(BannerVO vo);
	int sliderBannerInsert(BannerVO vo);
	int sliderBannerDelete(BannerVO vo);
	
}
