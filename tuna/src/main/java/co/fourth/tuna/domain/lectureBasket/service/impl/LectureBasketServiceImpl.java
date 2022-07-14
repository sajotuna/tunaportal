package co.fourth.tuna.domain.lectureBasket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.lectureBasket.mapper.LectureBasketMapper;
import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

@Service
public class LectureBasketServiceImpl implements LectureBasketService {

	@Autowired
	private LectureBasketMapper mapper;
	
	@Override
	public void baskInsert(LectureBasketVO vo) {
		mapper.baskInsert(vo);
	}

	@Override
	public void baskDelete(LectureBasketVO vo) {
		mapper.baskDelete(vo);
		
	}
	@Override
	public void courDelete(LectureBasketVO vo) {
		mapper.courDelete(vo);
	}

	@Override
	public boolean FindRoom(String stNo, String day, String startTime, String endTime) {
		return mapper.FindRoom(stNo,day, startTime, endTime);
	}

	@Override
	public String FindCourseGrade(LectureBasketVO vo) {
		return mapper.FindCourseGrade(vo);
	}
	@Override
	public boolean FindSubject(LectureBasketVO vo) {
		return mapper.FindSubject(vo);
	}

}
