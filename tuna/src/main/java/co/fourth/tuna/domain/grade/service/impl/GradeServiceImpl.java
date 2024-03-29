package co.fourth.tuna.domain.grade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
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
import co.fourth.tuna.util.CustomException;
import co.fourth.tuna.util.ResMsgService;
import co.fourth.tuna.util.ResponseMsg;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired GradeMapper mapper;
	@Autowired GradeRatioMapper ratioMapper; 
	
	@Autowired TaskService taskService;
	@Autowired GradeService gradeService;
	@Autowired AttendanceService attendanceService;
	@Autowired ResMsgService resMsgService;
	
	@Autowired
	MessageSourceAccessor msg;

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
	public ResponseMsg updateTaskGradeByStudentIdAndSubjectId(int stNo, int sbjNo) throws CustomException{
		ResponseMsg res = resMsgService.build("title.suc.eroll",
				new String[]{"msg.suc.enroll","성적"},
				ResponseMsg.SUCCESS);
		
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
		
		return res;
	}

	@Override
	@Transactional(rollbackFor = {CustomException.class})
	public ResponseMsg updateGradeListByGradeNo(List<GradeFormVO> list) throws CustomException {
		ResponseMsg result = resMsgService.build(
				"title.suc.enroll",
				new String[]{"msg.suc.update", "성적"},
				ResponseMsg.SUCCESS);
		
		for(GradeFormVO form : list) {
			result = gradeService.updateGradeByGradeNo(form);
		}
		return result;
	}

	@Override
	@Transactional
	public ResponseMsg updateGradeListByStudentNoAndSbjectNo(List<GradeFormVO> list) throws CustomException {
		ResponseMsg res = resMsgService.build(
				"title.suc.enroll",
				new String[]{"msg.suc.enroll", "성적"},
				ResponseMsg.SUCCESS);
		for(GradeFormVO form : list) {
			gradeService.updateGradeByStudentNoAndSubjectNo(form);
		}
		return res;
	}

	@Override
	@Transactional
	public ResponseMsg updateSubmitTaskGrade(EclassSubmitTaskScoreForm form) throws CustomException{
		ResponseMsg res = resMsgService.build(
			"title.suc.enroll",
			new String[]{"msg.suc.enroll", "점수"},
			ResponseMsg.SUCCESS);
		
		res = taskService.updateSubmitTaskScoreByVO(form);
		for( SubmitTaskVO vo : form.getSubmitTaskList() ) {
			if(vo.getNo() == null) continue;
			gradeService.updateTaskGradeByStudentIdAndSubjectId(vo.getStNo(), form.getSbjno());			
		}
		
		return res;
	}

	@Override
	public GradeVO getOneByStudentIdAndSubjectId(int stno, int sbjno) {
		return mapper.findOneByStudentIdAndSubjectId(stno, sbjno);
	}

	@Override
	public ResponseMsg updateAttendanceTaskGrade(int stno, int sbjno) throws CustomException {
		List<AttendanceVO> attens = attendanceService.getListByStudentIdAndSbjno(stno, sbjno);
		if(attens.size() < 1) {
			return resMsgService.build("title.error.enroll",
					new String[]{"msg.err.fail", "출석 성적"}, 
					ResponseMsg.ERROR);
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
	public ResponseMsg updateGradeByGradeNo(GradeFormVO vo) throws CustomException {
		ResponseMsg result = resMsgService.build(
				"title.suc.enroll", 
				new String[]{"msg.suc.enroll", "성적 등록"}, 
				ResponseMsg.SUCCESS);

		if(!scoreLimitFilter(vo)) {
			result = resMsgService.build(
					"title.err.enroll", 
					"msg.err.wrongInput", 
					ResponseMsg.ERROR);
			throw new CustomException(result);
		}
		if(mapper.updateGradeByGradeNo(vo) < 1) {
			return resMsgService.build(
					"title.err.enroll",
					"msg.err.wrongInput",
					ResponseMsg.ERROR);
		}
		
		GradeVO grade = mapper.selectOneByGradeId(vo.getNo());
		GradeFormVO form = new GradeFormVO();
		form.setSbjNo(grade.getSbjNo());
		form.setStNo(grade.getStNo());
		form.setTotal(computeTotalScore(grade.getSbjNo(), grade.getStNo()));
		if(mapper.updateGradeByStudentNoAndSubjectNo(form) < 1) {
			return new ResponseMsg(msg.getMessage("title.err.enroll"),
					msg.getMessage("msg.err.fail", new String[] {"종합성적 등록"}), ResponseMsg.ERROR);
		}
		
		return result;
	}
	
	@Override
	public ResponseMsg updateGradeByStudentNoAndSubjectNo(GradeFormVO vo) throws CustomException {
		ResponseMsg result = resMsgService.build(
				"title.suc.enroll",
				new String[]{"msg.suc.enroll","성적 등록"},
				ResponseMsg.SUCCESS);
		
		if(!scoreLimitFilter(vo)) {
			result = resMsgService.build(
					"title.err.enroll",
					"msg.err.wrongInput",
					ResponseMsg.ERROR);
			throw new CustomException(result);
		}
		if ( mapper.updateGradeByStudentNoAndSubjectNo(vo) < 1) {
			
			return new ResponseMsg(
					msg.getMessage("title.err.enroll")
					, msg.getMessage("msg.err.fail",new String[]{"성적 등록"})
					, ResponseMsg.ERROR );
		}
		
		GradeFormVO grade = new GradeFormVO();
		grade.setSbjNo(vo.getSbjNo());
		grade.setStNo(vo.getStNo());
		grade.setTotal(computeTotalScore(vo.getSbjNo(), vo.getStNo()));
		if ( mapper.updateGradeByStudentNoAndSubjectNo(grade) < 1) {
			return new ResponseMsg(
					msg.getMessage("title.err.enroll"),
					msg.getMessage("msg.err.fail", new String[] {"종합성적 등록"}),
					ResponseMsg.ERROR);
		}
		
		return result;
	}
	
	public Boolean scoreLimitFilter(GradeFormVO vo) {
		
		if ( vo.getAttd() != null && vo.getAttd() > 100 
			|| vo.getMiddle() != null && vo.getMiddle() > 100 
			|| vo.getFinals() != null && vo.getFinals() > 100 
			|| vo.getTask() != null && vo.getTask() > 100 ) {
			return false;
		}
		if( vo.getAttd() != null && vo.getAttd() < 0
				|| vo.getMiddle() != null && vo.getMiddle() < 0
				|| vo.getFinals() != null && vo.getFinals() < 0
				|| vo.getTask() != null && vo.getTask() < 0 ) {
			return false;
		}
		
		return true;
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
