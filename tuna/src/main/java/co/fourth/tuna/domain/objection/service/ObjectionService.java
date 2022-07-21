package co.fourth.tuna.domain.objection.service;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;

public interface ObjectionService {

	public List<ObjectionVO> objectionListOfStud(ObjectionVO vo);
	public List<Map<String, Object>> objectionListOfProf(int pfNo, String seasonCode);
	public Map<String, Object> objectionSelect(int objNo);
	public int objectionInsert(ObjectionVO vo);
	public int objectionUpdate(ObjectionVO vo);
	
}
