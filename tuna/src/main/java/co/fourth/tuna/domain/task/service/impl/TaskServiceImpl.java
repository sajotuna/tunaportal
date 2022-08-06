package co.fourth.tuna.domain.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.SubmitTaskWithTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.util.ResMsgService;
import co.fourth.tuna.util.ResponseMsg;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskMapper map;
	@Autowired
	GradeService gradeService;
	@Autowired
	TaskService service;
	@Autowired
	ResMsgService msg;
	
	@Override
	public TaskVO taskList(TaskVO vo) {
		return null;
	}

	@Override
	public void taskSubmission(SubmitTaskVO vo) {
		map.taskSubmission(vo);
	}


	@Override
	public TaskVO taskSelect(TaskVO vo) {
		return map.taskSelect(vo);
	}

	@Override
	public List<SubmitTaskVO> findSubmission(SubmitTaskVO vo) {
		return map.findSubmission(vo);
	}

	@Override
	public void deleteSubmitTask(SubmitTaskVO vo) {
		map.deleteSubmitTask(vo);
	}

	@Override
	public ResponseMsg insertTaskByVO(TaskVO vo) {
		ResponseMsg res = msg.build(
				"title.suc.enroll",
				new String[]{"msg.suc.enroll","과제"}, 
				ResponseMsg.SUCCESS);
		if(vo.getTitle().isBlank()) {
			return msg.build(
					"title.err.enroll",
					new String[]{"msg.err.input", "제목"}, 
					ResponseMsg.ERROR);
		}
		if(vo.getLimitDate() == null) {
			return msg.build(
					"title.err.enroll", 
					new String[]{"msg.err.input", "만료일"}, 
					ResponseMsg.ERROR);
		}
		if(map.insertTaskByVO(vo) < 1) {
			throw new Error("등록 실패");
		}
		return res;
	}

	@Override
	public List<TaskVO> findListBySubjectId(int sbjno) {
		return map.findListBySubjectId(sbjno);
	}

	@Override
	@Transactional
	public ResponseMsg updateSubmitTaskScoreByVO(EclassSubmitTaskScoreForm data) {
		ResponseMsg res = msg.build(
				"title.suc.enroll",
				new String[]{"msg.suc.enroll","점수"},
				ResponseMsg.SUCCESS);
		
		for( SubmitTaskVO vo : data.getSubmitTaskList() ) { // student list
			if ( vo.getNo() == null ) continue; 
			if( (vo.getScore() > 100) || (vo.getScore() < 0) ) {
				return msg.build(
						"title.suc.enroll",
						"msg.err.wrongInput",
						ResponseMsg.ERROR);
			}
			if( map.updateSubmitTaskByVO(vo) < 0 ) {
				return msg.build(
						"title.suc.enroll",
						new String[]{"msg.err.fail","점수"},
						ResponseMsg.ERROR);
			}
		}
		
		return res;
	}

	@Override
	public SubmitTaskVO findSubmitTaskByStudentIdAndTaskId(int stno, int taskno) {
		return map.findSubmitTaskListByStudentIdAndTaskId(stno, taskno);
	}

	@Override
	public void updateTaskFile(SubmitTaskVO vo) {
		map.updateTaskFile(vo);
	}

	public List<SubmitTaskVO> findSubmitTaskListByStudentIdAndSubjectId(int stNo, int sbjNo) {
		return map.findSubmitTaskListByStudentIdAndSubjectId(stNo, sbjNo);
	}

	@Override
	public List<SubmitTaskWithTaskVO> getSubmitTaskWithTaskListByStudentIdAndSubjectId(int stno, int sbjno) {
		List<SubmitTaskWithTaskVO> list = map.selectSubmitTaskWithTaskListByStudentIdAndSubjectId(stno, sbjno);
		for(SubmitTaskWithTaskVO submitTask : list) {
			submitTask.setTask(service.getTaskByTaskId(submitTask.getTaskNo()));
		}
		return list;
	}

	@Override
	public TaskVO getTaskByTaskId(int taskno) {
		return map.selectOneByTaskId(taskno);
	}
	
	

}
