package co.fourth.tuna.domain.grade.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;

public interface GradeMapper {

	public List<Map<String, Object>> currentSemesterGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public Map<String, Object> currentSemesterGradeTotal(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public List<Map<String, Object>> seasonSubjectGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	

	public GradeVO findBySbjectNo(GradeVO vo);
	public GradeVO findOneByStudentIdAndSubjectId(
				@Param("stno")int stno, 
				@Param("sbjno")int sbjno);
	
	public int updateGradeByGradeNo(GradeFormVO vo);
	public int updateGradeByStudentNoAndSubjectNo(GradeFormVO vo);
	
}
