package co.fourth.tuna.domain.task.mapper;

import java.util.List;

import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

public interface TaskMapper {

	//과제 목록 조회
	public List<TaskVO> taskList(TaskVO vo);
	
	//과제 상세보기
	public SubmitTaskVO taskSelect(SubmitTaskVO vo);
}
