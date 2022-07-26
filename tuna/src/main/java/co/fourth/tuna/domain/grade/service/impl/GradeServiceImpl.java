package co.fourth.tuna.domain.grade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired GradeMapper mapper;
	
	@Autowired TaskService taskService;
	@Autowired GradeService gradeService;

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
	public String updateTaskGradeByStudentIdAndSubjectId(int stNo, int sbjNo) {
		List<GradeFormVO> gradeList = new ArrayList<GradeFormVO>();
		List<TaskVO> taskList = taskService.findListBySubjectId(sbjNo);
		int sum = 0;
		int cnt = 0;
		int avg = 0;
		for( TaskVO task : taskList) {
			SubmitTaskVO submission = taskService.findSubmitTaskByStudentIdAndTaskId(stNo, task.getNo());
			if(submission != null) {
				sum += submission.getScore();
			}
			cnt++;
		}
		avg = (int) Math.floor(sum/cnt);
		
		GradeFormVO grade = new GradeFormVO();
		grade.setStNo(stNo);
		grade.setTask(avg);
		grade.setSbjNo(sbjNo);
		gradeList.add(grade);
	
		updateGradeListByStudentNoAndSbjectNo(gradeList);
		
		return "업데이트 성공";
	}

	@Override
	@Transactional
	public String updateGradeListByGradeNo(List<GradeFormVO> list) {
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
			if ( mapper.updateGradeByGradeNo(form) < 1) {
				throw new Error("수정에 실패 했습니다");
			}
			
		}
		return "성공적으로 등록 되었습니다.";
	}

	@Override
	@Transactional
	public String updateGradeListByStudentNoAndSbjectNo(List<GradeFormVO> list) {
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
			if ( mapper.updateGradeByStudentNoAndSubjectNo(form) < 1) {
				throw new Error("수정에 실패 했습니다");
			}
			
		}
		return "성공적으로 등록 되었습니다.";
	}

	@Override
	@Transactional
	public String updateSubmitTaskGrade(EclassSubmitTaskScoreForm form) throws Error{
		taskService.updateSubmitTaskScoreByVO(form);
		
		for( SubmitTaskVO vo : form.getSubmitTaskList() ) {
			gradeService.updateTaskGradeByStudentIdAndSubjectId(vo.getStNo(), form.getSbjno());			
		}
		
		return "성공적으로 등록 되었습니다.";
	}
	
	// TODO 성적 등록시 total 계산해서 넣기

}
