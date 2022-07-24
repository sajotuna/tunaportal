package co.fourth.tuna.domain.task.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.task.vo.TaskVO;

@Controller
public class TaskController {
	
	@Autowired private SubjectMapper map;
	@Autowired private TaskService service;
	
//	@RequestMapping("/eclass/student/taskList")
//	public String taskList(Model model) {
//		
//		//단일과목과제 조회
//		StudentVO sv = new StudentVO();
//		SubjectVO sb = new SubjectVO();
//		sv.setNo(13168019);
//		sb.setNo(90079);
//		List<SubjectVO> sbjli = map.selectOneSubTask(sv, sb);
//		model.addAttribute("sbjli", sbjli);
//		return "eclass/stud/taskList";
//	}
//	
//	@Autowired SqlSession sql;
//	@RequestMapping("/eclass/student/taskSelect")
//	public String taskSelect(Model model, TaskVO vo) {
//		vo.setNo(1);
//		vo.setSbjNo(90079);
//		List<Map<String, Object>> tsk = sql.selectList("co.fourth.tuna.domain.task.mapper.TaskMapper.taskSelect", vo);
//		
//		model.addAttribute("tsk", tsk);
//		
//		return "eclass/stud/taskSelect";
//	}
	
	@PostMapping(value="/staff/insertTask")
	public ResponseEntity<String> insertTask(
			@RequestBody TaskVO task) {
		ResponseEntity<String> resEntity = null;
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		try {
			resEntity = new ResponseEntity<String>(
					service.insertTaskByVO(task),
					resHeaders,
					HttpStatus.OK);
		} catch (Error e) {
			resEntity = new ResponseEntity<String>(
					e.getMessage(),
					resHeaders,
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(
					e.getMessage(),
					resHeaders,
					HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
	@ResponseBody
	@PostMapping(value="/staff/eclass/getTaskList")
	public List<TaskVO> getTaskList() {
		// TODO
		return null;
	}
}
