package co.fourth.tuna.domain.task.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.domain.task.vo.EclassTaskContentVO;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentWithSubmitTaskVO;

@Controller
public class TaskController {
	
	@Autowired private TaskService taskService;
	@Autowired private StudentService studService;
	
	@PostMapping(value="/staff/insertTask")
	public ResponseEntity<String> insertTask(
			@RequestBody TaskVO task) {
		ResponseEntity<String> resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		try {
			resEntity = new ResponseEntity<String>(
					taskService.insertTaskByVO(task),
					resHeaders,
					HttpStatus.OK);
		} catch (Error e) {
			resEntity = new ResponseEntity<String>(
					e.getMessage(),
					resHeaders,
					HttpStatus.BAD_REQUEST);
		} catch (Throwable e) {
			resEntity = new ResponseEntity<String>(
					e.getMessage(),
					resHeaders,
					HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@ResponseBody
	@PostMapping(value="/staff/task/content")
	public EclassTaskContentVO getTaskContent(
			@RequestBody Map<String, String> req) {
		int sbjno = Integer.parseInt(req.get("sbjno"));
		int taskno = Integer.parseInt(req.get("taskno"));
		
		List<TaskVO> tasks = taskService.findListBySubjectId(sbjno);

		if( req.get("taskno") == null || req.get("taskno").equals("0") ) {
			taskno = tasks.get(0).getNo();
		}
		
		List<StudentWithSubmitTaskVO> students = studService.findListWithSubmitTaskByTaskId(taskno);
		
		return new EclassTaskContentVO(tasks, students);
	}
	
	
	@PostMapping(value="/staff/eclass/getTaskList")
	public List<TaskVO> getTaskList(@RequestBody Map<String, Integer> req) {
		
		List<TaskVO> list =  taskService.findListBySubjectId(req.get("sbjno"));
		
		return list;
	}
	
}
