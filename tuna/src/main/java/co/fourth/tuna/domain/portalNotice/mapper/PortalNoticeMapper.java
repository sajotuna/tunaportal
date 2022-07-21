package co.fourth.tuna.domain.portalNotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

public interface PortalNoticeMapper {
	List<PortalNoticeVO> adminNoticeList(
			@Param("state") int state, @Param("key") String key,
			@Param("startList") int startList, @Param("endList")int endList);
	
	List<PortalNoticeVO> portalNoticeList(
			@Param("state") int state, @Param("key") String key,
			@Param("startList") int startList, @Param("endList")int endList);

	PortalNoticeVO noticeSelect(PortalNoticeVO vo);

	int noticeInsert(PortalNoticeVO vo);

	int noticeDelete(PortalNoticeVO vo);

	int noticeUpdate(PortalNoticeVO vo);

	//파일
	List<PortalNoticeFileVO> fileList();

	List<PortalNoticeFileVO> fileSelect(int pnNo);

	int fileInsert(PortalNoticeFileVO fileVo);

	int fileDelete(PortalNoticeFileVO fileVo);
	
	int fileAllDelete(PortalNoticeFileVO fileVo);
}
