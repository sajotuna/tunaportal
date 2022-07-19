package co.fourth.tuna.domain.objection.service;

import java.util.List;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;

public interface ObjectionService {

	public List<ObjectionVO> objectionListSelect(ObjectionVO vo);
	public ObjectionVO objectionSelect(ObjectionVO vo);
	public int objectionContentInsert(ObjectionVO vo);
	public int objectionAnswerInsert(ObjectionVO vo);
	public int objectionAnswerUpdate(ObjectionVO vo);
	
}
