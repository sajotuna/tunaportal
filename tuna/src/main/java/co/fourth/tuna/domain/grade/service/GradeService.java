package co.fourth.tuna.domain.grade.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;

public interface GradeService {
	
	public List<Map<String, Object>> currentSemesterGradeSelect(int stNo, String seasonCode);
	public Map<String, Object> currentSemesterGradeTotal(int stNo, String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(int stNo);
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(int stNo);
	
	public String updateGradeList(List<GradeFormVO> vo);
}
