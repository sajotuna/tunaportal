package co.fourth.tuna.domain.portalNotice.service;

import java.util.List;

import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

public interface PortalNoticeService {

	List<PortalNoticeVO> adminNoticeList(int state, String key, int startList, int endList);
	
	List<PortalNoticeVO> portalNoticeList(int state, String key, int startList, int endList);

	PortalNoticeVO noticeSelect(PortalNoticeVO vo);

	int noticeInsert(PortalNoticeVO vo);

	int noticeDelete(PortalNoticeVO vo);

	int noticeUpdate(PortalNoticeVO vo);

	List<PortalNoticeFileVO> fileList();

	List<PortalNoticeFileVO> fileSelect(int pnNo);

	int fileInsert(PortalNoticeFileVO fileVo);

	int fileDelete(PortalNoticeFileVO fileVo);
	
	int fileAllDelete(PortalNoticeFileVO fileVo);

	int getNoticeCnt(String visible, int state, String key);

}
