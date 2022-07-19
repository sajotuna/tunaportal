package co.fourth.tuna.domain.objection.mapper;

import java.util.List;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface ObjectionMapper {
	
	public List<ObjectionVO> findBySubject(SubjectVO vo);
	public List<ObjectionVO> findListBySubjectId(int sbjno);
}
