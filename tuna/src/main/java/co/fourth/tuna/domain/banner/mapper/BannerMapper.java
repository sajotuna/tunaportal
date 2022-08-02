package co.fourth.tuna.domain.banner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.banner.vo.BannerVO;

public interface BannerMapper {
	
	List<BannerVO> bannerListSelect(@Param("startList")int startList, 
			                        @Param("endList")int endList,
			                        @Param("bannerCode")String bannerCode);
	BannerVO bannerSelect(String bannerCode);
	int bannerInsert(BannerVO vo);
	int bannerDelete(BannerVO vo);
	
	List<BannerVO> sliderBannerSelect();
	int sliderBannerUpdate(BannerVO vo);
	
	int getBannerCnt(String bannerCode);

}