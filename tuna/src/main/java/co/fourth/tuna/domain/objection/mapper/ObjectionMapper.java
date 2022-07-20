package co.fourth.tuna.domain.objection.mapper;

import java.util.ArrayList;
import java.util.List;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface ObjectionMapper {
	
	public ArrayList<ObjectionVO> findBySubjection(SubjectVO vo);
	public List<ObjectionVO> objectionListOfStud(ObjectionVO vo);
	public List<ObjectionVO> objectionListOfProf(ObjectionVO vo);
	public ObjectionVO objectionSelect(ObjectionVO vo);
	public int objectionInsert(ObjectionVO vo);
	public int objectionUpdate(ObjectionVO vo);
}
