package co.fourth.tuna.domain.grade.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface GradeService {
	
	public List<Map<String, Object>> currentSemesterGradeSelect(int stNo, String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(int stNo);
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(int stNo);

}
