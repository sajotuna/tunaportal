package co.fourth.tuna.domain.banner.service;

import java.util.List;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerService {

	List<BannerVO> bannerListSelect(int startList, int endList);
	BannerVO bannerSelect(String bannerCode);
	int bannerInsert(BannerVO vo);
	int bannerDelete(BannerVO vo);
	
	List<BannerVO> sliderBannerSelect();
	int sliderBannerUpdate(BannerVO vo);
	
}
