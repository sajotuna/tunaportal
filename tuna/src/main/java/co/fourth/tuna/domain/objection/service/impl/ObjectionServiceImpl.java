package co.fourth.tuna.domain.objection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.objection.mapper.ObjectionMapper;
import co.fourth.tuna.domain.objection.service.ObjectionService;
import co.fourth.tuna.domain.objection.vo.ObjectionVO;

@Service
public class ObjectionServiceImpl implements ObjectionService {
	
	@Autowired ObjectionMapper mapper;

	@Override
	public List<ObjectionVO> objectionListSelect(ObjectionVO vo) {
		return mapper.objectionListSelect(vo);
	}

	@Override
	public ObjectionVO objectionSelect(ObjectionVO vo) {
		return mapper.objectionSelect(vo);
	}

	@Override
	public int objectionContentInsert(ObjectionVO vo) {
		return mapper.objectionContentInsert(vo);
	}

	@Override
	public int objectionAnswerInsert(ObjectionVO vo) {
		return mapper.objectionAnswerInsert(vo);
	}

	@Override
	public int objectionAnswerUpdate(ObjectionVO vo) {
		return mapper.objectionAnswerUpdate(vo);
	}

}
