package co.fourth.tuna.domain.lectureBasket.mapper;

import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

public interface LectureBasketMapper {

	public boolean FindRoom(String stNo,String day, String startTime, String endTime);
	
	public void baskInsert(LectureBasketVO vo);
	public void baskDelete(LectureBasketVO vo);
}
