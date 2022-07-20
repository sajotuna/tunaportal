package co.fourth.tuna.domain.grade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.grade.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired GradeMapper mapper;

	@Override
	public List<Map<String, Object>> currentSemesterGradeSelect(int stNo, String seasonCode) {
		return mapper.currentSemesterGradeSelect(stNo, seasonCode);
	}
	
	@Override
	public Map<String, Object> currentSemesterGradeTotal(int stNo, String seasonCode) {
		return mapper.currentSemesterGradeTotal(stNo, seasonCode);
	}

	@Override
	public List<Map<String, Object>> subjectGradeSelect(int stNo) {
		return mapper.subjectGradeSelect(stNo);
	}

	@Override
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode) {
		return mapper.seasonSubjectGradeSelect(stNo, seasonCode);
	}

	@Override
	public List<Map<String, Object>> avgGradeSelect(int stNo) {
		return mapper.avgGradeSelect(stNo);
	}


}
