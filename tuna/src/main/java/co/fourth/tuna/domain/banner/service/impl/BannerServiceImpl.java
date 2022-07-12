package co.fourth.tuna.domain.banner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.fourth.tuna.domain.banner.mapper.BannerMapper;
import co.fourth.tuna.domain.banner.service.BannerService;
import co.fourth.tuna.domain.banner.vo.BannerVO;

@Repository("bannerDao")
public class BannerServiceImpl implements BannerService {
	
	@Autowired BannerMapper map;
	
	@Override
	public BannerVO bannerSelect(String bannerCode) {
		return map.bannerSelect(bannerCode);
	}

	@Override
	public int bannerInsert(BannerVO vo) {
		return map.bannerInsert(vo);
	}

	@Override
	public int sliderBannerInsert(BannerVO vo) {
		return map.sliderBannerInsert(vo);
	}

	@Override
	public int sliderBannerDelete(BannerVO vo) {
		return map.sliderBannerDelete(vo);
	}

}
