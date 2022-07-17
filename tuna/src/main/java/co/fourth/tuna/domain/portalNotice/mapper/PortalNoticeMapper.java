package co.fourth.tuna.domain.portalNotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

public interface PortalNoticeMapper {
	List<PortalNoticeVO> noticeList(
			@Param("state") int state, @Param("key") String key,
			@Param("pageNum") int pageNum, @Param("size")int size);

	PortalNoticeVO noticeSelect(PortalNoticeVO vo);

	int noticeInsert(PortalNoticeVO vo);

	int noticeDelete(PortalNoticeVO vo);

	int noticeUpdate(PortalNoticeVO vo);

	//파일
	List<PortalNoticeFileVO> fileList(PortalNoticeFileVO fileVo);

	List<PortalNoticeFileVO> fileSelect(int pnNo);

	int fileInsert(PortalNoticeFileVO fileVo);

	int fileDelete(PortalNoticeFileVO fileVo);
}
