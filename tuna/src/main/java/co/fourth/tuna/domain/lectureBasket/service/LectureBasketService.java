package co.fourth.tuna.domain.lectureBasket.service;

import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

public interface LectureBasketService {
	public boolean FindRoom(String stNo,String day, String startTime, String endTime);
	public void baskInsert(LectureBasketVO vo);
	public void baskDelete(LectureBasketVO vo);
	public String basketApplyMsg(LectureBasketVO vo);
	public String FindCourseGrade(LectureBasketVO vo);
	public int subjectTarget(LectureBasketVO vo);
}
