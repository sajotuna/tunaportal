package co.fourth.tuna.domain.task.service;

import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

public interface TaskService {

	//과제 목록 조회
	public TaskVO taskList(TaskVO vo);
	
	//과제 상세보기
	public SubmitTaskVO taskSelect(SubmitTaskVO vo);

	//과제 파일 제출
}
