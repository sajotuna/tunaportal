package co.fourth.tuna.domain.portalNotice.service;

import java.util.List;

import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

public interface PortalNoticeService {

	List<PortalNoticeVO> noticeList(int state, String key);
	PortalNoticeVO noticeSelect(PortalNoticeVO vo);
	int noticeInsert(PortalNoticeVO vo);	
	int fileInsert(PortalNoticeFileVO vo);
	int noticeDelete(PortalNoticeVO vo);
	int fileDelete(PortalNoticeFileVO vo);
}
