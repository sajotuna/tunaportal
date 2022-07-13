package co.fourth.tuna.domain.objection.mapper;

import java.util.ArrayList;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface ObjectionMapper {
	
	public ArrayList<ObjectionVO> findBySubjection(SubjectVO vo);
}
