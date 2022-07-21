package co.fourth.tuna.domain.objection.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.objection.vo.ObjectionVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;

public interface ObjectionMapper {
	
	public List<ObjectionVO> findBySubject(SubjectVO vo);
	public List<ObjectionVO> findListBySubjectId(int sbjno);
  
	public List<ObjectionVO> objectionListOfStud(ObjectionVO vo);
	public List<Map<String, Object>> objectionListOfProf(@Param("pfNo") int pfNo, @Param("seasonCode") String seasonCode);
	public Map<String, Object> objectionSelect(int objNo);
	public int objectionInsert(ObjectionVO vo);
	public int objectionUpdate(ObjectionVO vo);
  
}
