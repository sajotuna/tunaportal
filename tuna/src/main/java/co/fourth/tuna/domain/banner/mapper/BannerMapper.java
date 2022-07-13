package co.fourth.tuna.domain.banner.mapper;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerMapper {

	BannerVO bannerSelect(String bannerCode);
	int bannerInsert(BannerVO vo);
	int sliderBannerInsert(BannerVO vo);
	int sliderBannerDelete(BannerVO vo);

}
