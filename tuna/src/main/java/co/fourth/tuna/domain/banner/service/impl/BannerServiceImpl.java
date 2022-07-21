package co.fourth.tuna.domain.banner.service.impl;

import java.util.List;

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
	public List<BannerVO> bannerListSelect(int startList, int endList) {
		return map.bannerListSelect(startList, endList);
	}
	
	@Override
	public int bannerDelete(BannerVO vo) {
		return map.bannerDelete(vo);
	}

	@Override
	public List<BannerVO> sliderBannerSelect() {
		return map.sliderBannerSelect();
	}

	@Override
	public int sliderBannerUpdate(BannerVO vo) {
		return map.sliderBannerUpdate(vo);
	}


}
