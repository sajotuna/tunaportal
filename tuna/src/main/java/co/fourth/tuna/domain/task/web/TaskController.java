package co.fourth.tuna.domain.task.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class TaskController {
	
	@Autowired private SubjectMapper map;
	@RequestMapping("/eclass/student/taskList")
	public String taskList(Model model) {
		
		//단일과목과제 조회
		StudentVO sv = new StudentVO();
		SubjectVO sb = new SubjectVO();
		sv.setNo(13168019);
		sb.setNo(90079);
		List<SubjectVO> sbjli = map.selectOneSubTask(sv, sb);
		model.addAttribute("sbjli", sbjli);
		return "eclass/stud/taskList";
	}
	
	@Autowired private TaskMapper mapper;
	@RequestMapping("/eclass/student/taskSelect")
	public String taskSelect(Model model, SubmitTaskVO vo) {
		
		
		
		return "eclass/stud/taskSelect";
	}

}
