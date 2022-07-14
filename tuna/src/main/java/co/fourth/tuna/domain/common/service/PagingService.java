package co.fourth.tuna.domain.common.service;

import co.fourth.tuna.domain.common.vo.PagingVO;

public interface PagingService {
	/**
	 * 테이블 이름, 한페이지에 보여줄 게시물 수 입력
	 * 전체 페이지 갯수, 전체 개시물 갯수 리텅
	 * @param vo 
	 * ex) vo.tableName("테이블"), vo.sizePerPage(10);
	 * @return vo (vo.length() vo.page())
	 */
	public PagingVO getPaging(PagingVO vo);
}
