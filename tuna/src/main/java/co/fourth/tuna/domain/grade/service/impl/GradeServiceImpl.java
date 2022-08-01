package co.fourth.tuna.domain.grade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.subject.mapper.GradeRatioMapper;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired GradeMapper mapper;
	@Autowired GradeRatioMapper ratioMapper; 
	
	@Autowired TaskService taskService;
	@Autowired GradeService gradeService;
	@Autowired AttendanceService attendanceService;

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
		
		return "성적이 성공적으로 등록 되었습니다.";
	}

	@Override
	@Transactional
	public String updateGradeListByGradeNo(List<GradeFormVO> list) {
		for(GradeFormVO form : list) {
			gradeService.updateGradeByGradeNo(form);
		}
		return "성적이 성공적으로 등록 되었습니다.";
	}

	@Override
	@Transactional
	public String updateGradeListByStudentNoAndSbjectNo(List<GradeFormVO> list) {
		for(GradeFormVO form : list) {
			gradeService.updateGradeByStudentNoAndSubjectNo(form);
		}
		return "성적이 성공적으로 등록 되었습니다.";
	}

	@Override
	@Transactional
	public String updateSubmitTaskGrade(EclassSubmitTaskScoreForm form) throws Error{
		taskService.updateSubmitTaskScoreByVO(form);
		for( SubmitTaskVO vo : form.getSubmitTaskList() ) {
			if(vo.getNo() == null) continue;
			gradeService.updateTaskGradeByStudentIdAndSubjectId(vo.getStNo(), form.getSbjno());			
		}
		
		return "성공적으로 등록 되었습니다.";
	}

	@Override
	public GradeVO getOneByStudentIdAndSubjectId(int stno, int sbjno) {
		return mapper.findOneByStudentIdAndSubjectId(stno, sbjno);
	}

	@Override
	public String updateAttendanceTaskGrade(int stno, int sbjno) {
		List<AttendanceVO> attens = attendanceService.getListByStudentIdAndSbjno(stno, sbjno);
		if(attens.size() < 1) {
			throw new Error("출결 현황이 없습니다.");
		}
		int score = computeAttendanceScore(attens);
		//GradeVO grade = gradeService.getOneByStudentIdAndSubjectId(stno, sbjno);
		GradeFormVO grade = new GradeFormVO();
		grade.setStNo(stno);
		grade.setSbjNo(sbjno);
		grade.setAttd(score);
		return gradeService.updateGradeByStudentNoAndSubjectNo(grade);
	}

	@Override
	public String updateGradeByGradeNo(GradeFormVO vo) throws Error {
		String result = scoreLimitFilter(vo);
		if(mapper.updateGradeByGradeNo(vo) < 1) {
			throw new Error("성적 등록에 실패 했습니다.");
		}
		
		GradeVO grade = mapper.selectOneByGradeId(vo.getNo());
		GradeFormVO form = new GradeFormVO();
		form.setSbjNo(grade.getSbjNo());
		form.setStNo(grade.getStNo());
		form.setTotal(computeTotalScore(grade.getSbjNo(), grade.getStNo()));
		if(mapper.updateGradeByStudentNoAndSubjectNo(form) < 1) {
			throw new Error("종합 성적 등록에 실패 했습니다.");
		}
		
		return result;
	}
	
	@Override
	public String updateGradeByStudentNoAndSubjectNo(GradeFormVO vo) throws Error {
		String result = scoreLimitFilter(vo);
		if ( mapper.updateGradeByStudentNoAndSubjectNo(vo) < 1) {
			throw new Error("성적 등록에 실패 했습니다.");
		}
		
		GradeFormVO grade = new GradeFormVO();
		grade.setSbjNo(vo.getSbjNo());
		grade.setStNo(vo.getStNo());
		grade.setTotal(computeTotalScore(vo.getSbjNo(), vo.getStNo()));
		if ( mapper.updateGradeByStudentNoAndSubjectNo(grade) < 1) {
			throw new Error("종합 성적 등록에 실패 했습니다.");
		}
		
		return result;
	}
	
	public String scoreLimitFilter(GradeFormVO vo) throws Error{
		if ( vo.getAttd() != null && vo.getAttd() > 100 
			|| vo.getMiddle() != null && vo.getMiddle() > 100 
			|| vo.getFinals() != null && vo.getFinals() > 100 
			|| vo.getTask() != null && vo.getTask() > 100 )
			throw new Error("100점을 넘을 수 없습니다.");
		if( vo.getAttd() != null && vo.getAttd() < 0
				|| vo.getMiddle() != null && vo.getMiddle() < 0
				|| vo.getFinals() != null && vo.getFinals() < 0
				|| vo.getTask() != null && vo.getTask() < 0 )
			throw new Error("0점보다 작을 수 없습니다.");
		
		return "성적 등록에 성공했습니다.";
	}
	
	@Override
	public int computeAttendanceScore(List<AttendanceVO> attens) {
		int score = 100; // 100점 만점
		int absence = 0; // 결석
		int lateness = 0; // 지각(1/3 결석)
		int count = attens.size(); // 수업 횟수
		
		// 1401:출석, 1402:결석, 1403:지각
		for(int i=0; i < attens.size()-1; i++) {
			if(attens.get(i).getStateCode() != null) {
				if(attens.get(i).getStateCode().equals("1402")) {
					absence++;
				} else if (attens.get(i).getStateCode().equals("1403")){
					lateness++;
				}
			}
		}
		
		// 결석 계산
		if(absence > 0) score -= (absence*100)/count;
		// 지각 계산
		if(lateness > 0) score -= (lateness/3*100)/count;

		return score;
	}

	@Override
	public int computeTotalScore(int sbjno, int stno) {
		int result, middle, finals, task, attd;
		GradeRatioVO ratio = getGradeRatioBySubjectId(sbjno);
		GradeVO grade = gradeService.getOneByStudentIdAndSubjectId(stno, sbjno);
		middle = grade.getMiddle()*ratio.getMiddle()/100;
		finals = grade.getFinals()*ratio.getFinals()/100;
		task = grade.getTask()*ratio.getTask()/100;
		attd = grade.getAttd()*ratio.getAttd()/100;
		
		result = middle+finals+task+attd;
		
		return result;
	}

	@Override
	public GradeRatioVO getGradeRatioBySubjectId(int sbjno) {
		return ratioMapper.findOneById(sbjno);
	}
	
	

}
