package co.fourth.tuna.domain.grade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;

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
	public List<Map<String, Object>> subjectGradeSelect(int stNo, String SeasonCode) {
		return mapper.subjectGradeSelect(stNo, SeasonCode);
	}

	@Override
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode) {
		return mapper.seasonSubjectGradeSelect(stNo, seasonCode);
	}

	@Override
	public List<Map<String, Object>> avgGradeSelect(int stNo, String SeasonCode) {
		return mapper.avgGradeSelect(stNo, SeasonCode);
	}

	@Override
	@Transactional
	public String updateGradeList(List<GradeFormVO> list) {
		for(GradeFormVO form : list) {
			if ( form.getAttd() != null && form.getAttd() > 100 
				|| form.getMiddle() != null && form.getMiddle() > 100 
				|| form.getFinals() != null && form.getFinals() > 100 
				|| form.getTask() != null && form.getTask() > 100 )
				throw new Error("100점을 넘을 수 없습니다.");
			if( form.getAttd() != null && form.getAttd() < 0
					|| form.getMiddle() != null && form.getMiddle() < 0
					|| form.getFinals() != null && form.getFinals() < 0
					|| form.getTask() != null && form.getTask() < 0 )
				throw new Error("0점보다 작을 수 없습니다.");
			if ( mapper.updateGradeByForm(form) < 1) {
				throw new Error("수정에 실패 했습니다");
			}
			
		}
		return "성공적으로 등록 되었습니다.";
	}


}
