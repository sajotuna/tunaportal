package co.fourth.tuna.domain.grade.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GradeMapper {

	public List<Map<String, Object>> currentSemesterGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(int stNo);
	public List<Map<String, Object>> seasonSubjectGradeSelect(@Param("stNo")int stNo, @Param("seasonCode")String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(int stNo);
	
}
