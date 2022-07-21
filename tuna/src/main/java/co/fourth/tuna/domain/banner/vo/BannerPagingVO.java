package co.fourth.tuna.domain.banner.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.fourth.tuna.web.portal.admin.PortalAdminController;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BannerPagingVO {
	
	private static Logger logger = LoggerFactory.getLogger(PortalAdminController.class); 
	
	// 게시글 목록 범위
	private int listSize;  // 목록 개수
	private int startList; // 현재 페이지의 시작 게시글 번호
	private int endList; // 현재 페이지의 끝 게시글 번호
	
	// 페이지 범위
	private int rangeSize; // 페이지 범위
	private int range;  // 현재 페이지 범위 시작 번호
	private int page;  // 현재 목록의 페이지 번호
	private int pageCnt; // 전체 페이지 범위의 개수
	private int startPage; // 각 페이지 범위 시작 번호
	private int endPage; // 각 페이지 범위 끝 번호
	
	private boolean prev; // 이전 페이지 여부
	private boolean next; // 다음 페이지 여부
	
	public BannerPagingVO(int listSize) {
		this.listSize = listSize;
	}
	
	public void pageInfo(int page, 
			             int range, 
                         int pageCnt,
                         int rangeSize) {
		
		this.page = page;
		this.range = range;
		this.pageCnt = pageCnt;
		this.rangeSize = rangeSize;
		
		// 시작 페이지
		this.startPage = (range-1) * rangeSize + 1;
		
		// 끝 페이지
		this.endPage = range * rangeSize;
		
		// 게시글 시작번호
		this.startList = (page-1) * listSize;
		
		// 게시판 끝번호
		this.endList = this.startList + listSize;
		
		// 이전 버튼
		this.prev = range == 1 ? false : true;
		
		// 다음 버튼
		if (this.endPage >= this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		} else {
			this.next = true;
		}
		
		logger.info("prev::"+this.prev+"next::"+this.next);
				
	}
	
}
