package co.fourth.tuna.domain.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskMapper map;
	
	@Override
	public TaskVO taskList(TaskVO vo) {
		return null;
	}

	@Override
	public SubmitTaskVO taskSelect(SubmitTaskVO vo) {
		return map.taskSelect(vo);
	}

}
