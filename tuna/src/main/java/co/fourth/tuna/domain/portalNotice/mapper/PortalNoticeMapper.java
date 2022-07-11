package co.fourth.tuna.domain.portalNotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

public interface PortalNoticeMapper {
	List<PortalNoticeVO> noticeList(@Param("state")int state, @Param("key") String key);
	PortalNoticeVO noticeSelect(PortalNoticeVO vo);
	int noticeInsert(PortalNoticeVO vo);
	
}
