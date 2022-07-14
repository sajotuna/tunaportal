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

	@Override
	public List<PortalNoticeVO> noticeList(int state, String key) {
		return map.noticeList(state, key);
	}
	
	public PortalNoticeVO noticeSelect(PortalNoticeVO vo) {
		return map.noticeSelect(vo);
	}
	
	public int noticeInsert(PortalNoticeVO vo) {
		return map.noticeInsert(vo);
	}
	
	public int fileInsert(PortalNoticeFileVO vo) {
		return map.fileInsert(vo);
	}
	
	public int noticeDelete(PortalNoticeVO vo) {
		return map.noticeDelete(vo);
	}
	
	public int fileDelete(PortalNoticeFileVO vo) {
		return map.fileDelete(vo);
	}
}
