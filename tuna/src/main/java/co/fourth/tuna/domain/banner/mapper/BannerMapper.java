package co.fourth.tuna.domain.banner.mapper;

import java.util.List;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerMapper {
	
	List<BannerVO> bannerListSelect();
	BannerVO bannerSelect(String bannerCode);
	int bannerDelete(BannerVO vo);
	int bannerInsert(BannerVO vo);
	int sliderBannerInsert(BannerVO vo);
	int sliderBannerDelete(BannerVO vo);

}
