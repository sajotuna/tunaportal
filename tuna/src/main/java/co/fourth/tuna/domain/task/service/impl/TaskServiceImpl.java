package co.fourth.tuna.domain.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskMapper map;
	
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
	public String insertTaskByVO(TaskVO vo) {
		if(vo.getTitle().isBlank()) {
			throw new Error("제목이 없습니다.");
		}
		if(vo.getLimitDate() == null) {
			throw new Error("마감일이 없습니다.");
		}
		if(map.insertTaskByVO(vo) < 1) {
			throw new Error("등록 실패");
		}
		return "등록 성공";
	}

	@Override
	public List<TaskVO> findListBySubjectId(int sbjno) {
		return map.findListBySubjectId(sbjno);
	}

	@Override
	@Transactional
	public String updateSubmitTaskScoreByVO(EclassSubmitTaskScoreForm data) {
		for( SubmitTaskVO vo : data.getSubmitTaskList() ) {
			if( (vo.getScore() > 100) || (vo.getScore() < 0) ) {
				throw new Error("점수가 100점보다 크거나 0보다 작을 수 없습니다.");
			}
			if( map.updateSubmitTaskByVO(vo) < 0 ) {
				throw new Error("등록 실패");
			}
			
			List<SubmitTaskVO> sblist = findListByStudentIdAndTaskId(vo.getStNo(), data.getTaskno());
			int sum = 0;
			int cnt = 0;
			List<GradeFormVO> gradeList;
			for(SubmitTaskVO sb : sblist ) {
				if(sb.getScore() != null) {
					sum += sb.getScore();
				}
				cnt++;				
			}
			int avg = (int) Math.floor(sum/cnt);
			GradeFormVO grade = new GradeFormVO();
			//grade.set
		}
		return "등록 성공";
	}

	@Override
	public List<SubmitTaskVO> findListByStudentIdAndTaskId(int stno, int taskno) {
		
		return null;
	}

}
