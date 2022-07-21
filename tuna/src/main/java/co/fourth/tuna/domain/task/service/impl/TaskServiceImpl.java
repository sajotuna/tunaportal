package co.fourth.tuna.domain.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.service.TaskService;
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

}
