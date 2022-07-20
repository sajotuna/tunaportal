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
	public List<ObjectionVO> objectionListOfStud(ObjectionVO vo) {
		return mapper.objectionListOfStud(vo);
	}

	@Override
	public List<ObjectionVO> objectionListOfProf(ObjectionVO vo) {
		return mapper.objectionListOfProf(vo);
	}

	@Override
	public ObjectionVO objectionSelect(ObjectionVO vo) {
		return mapper.objectionSelect(vo);
	}
	
	@Override
	public int objectionInsert(ObjectionVO vo) {
		return mapper.objectionInsert(vo);
	}

	@Override
	public int objectionUpdate(ObjectionVO vo) {
		return mapper.objectionUpdate(vo);
	}



}
