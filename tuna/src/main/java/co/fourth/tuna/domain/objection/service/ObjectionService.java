package co.fourth.tuna.domain.objection.service;

import java.util.List;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;

public interface ObjectionService {

	public List<ObjectionVO> objectionListOfStud(ObjectionVO vo);
	public List<ObjectionVO> objectionListOfProf(ObjectionVO vo);
	public ObjectionVO objectionSelect(ObjectionVO vo);
	public int objectionInsert(ObjectionVO vo);
	public int objectionUpdate(ObjectionVO vo);
	
}
