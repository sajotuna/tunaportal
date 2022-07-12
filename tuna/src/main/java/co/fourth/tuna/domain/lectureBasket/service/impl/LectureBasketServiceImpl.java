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

}
