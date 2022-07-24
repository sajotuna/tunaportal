package co.fourth.tuna.domain.task.service;

import java.util.List;

import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;

public interface TaskService {

	//과제 목록 조회
	public TaskVO taskList(TaskVO vo);
	
	//과제 상세보기
	public TaskVO taskSelect(TaskVO vo);

	//과제 파일 제출
	public void taskSubmission(SubmitTaskVO vo);
	
	//제출한 파일 조회
	 public List<SubmitTaskVO> findSubmission(SubmitTaskVO vo);
	
	//제출한 파일 삭제
	public void deleteSubmitTask(SubmitTaskVO vo);
	
	// 과제 등록
	public String insertTaskByVO(TaskVO vo);
}
