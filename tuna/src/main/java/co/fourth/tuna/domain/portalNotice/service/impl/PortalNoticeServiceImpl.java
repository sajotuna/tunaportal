package co.fourth.tuna.domain.portalNotice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.fourth.tuna.domain.portalNotice.mapper.PortalNoticeMapper;
import co.fourth.tuna.domain.portalNotice.service.PortalNoticeService;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

@Repository("noticeDao")
public class PortalNoticeServiceImpl implements PortalNoticeService {
	@Autowired
	private PortalNoticeMapper map;

	//공지사항
	@Override
	public List<PortalNoticeVO> adminNoticeList(int state, String key, int startList, int endList) {
		return map.adminNoticeList(state, key, startList, endList);
	}
	
	@Override
	public List<PortalNoticeVO> portalNoticeList(int state, String key, int startList, int endList) {
		return map.portalNoticeList(state, key, startList, endList);
	}

	
	public PortalNoticeVO noticeSelect(PortalNoticeVO vo) {
		return map.noticeSelect(vo);
	}
	
	
	public int noticeInsert(PortalNoticeVO vo) {
		return map.noticeInsert(vo);
	}
	
	public int noticeUpdate(PortalNoticeVO vo) {
		return map.noticeUpdate(vo);
	}
	
	public int noticeDelete(PortalNoticeVO vo) {
		return map.noticeDelete(vo);
	}
	
	
	//파일
	public List<PortalNoticeFileVO> fileList() {
		 return map.fileList();
	}
	
	public List<PortalNoticeFileVO> fileSelect(int pnNo) {
		return map.fileSelect(pnNo);
	}
	
	public int fileInsert(PortalNoticeFileVO vo) {
		return map.fileInsert(vo);
	}

	
	public int fileDelete(PortalNoticeFileVO vo) {
		return map.fileDelete(vo);
	}
	
	public int fileAllDelete(PortalNoticeFileVO vo) {
		return map.fileAllDelete(vo);
	}

	@Override
	public int getNoticeCnt(String visible) {
		return map.getNoticeCnt(visible);
	}



}
