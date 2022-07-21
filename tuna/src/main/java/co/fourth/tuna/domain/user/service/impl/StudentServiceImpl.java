package co.fourth.tuna.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.domain.user.mapper.StudentMapper;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;
	@Autowired
	private AttendanceMapper attenMap;
	@Autowired
	private TaskMapper taskMap;
	@Autowired
	private GradeMapper gradeMap;
	
	@Override
	public StudentVO findById(StudentVO vo) {
		return mapper.findById(vo);
	}

	@Override
	public void studUpdate(StudentVO vo) {
		mapper.studUpdate(vo);
	}

	@Override
	public void AdminStudUpdate(StudentVO vo) {
		mapper.AdminStudUpdate(vo);
	}

	@Override
	public List<StudentExVO> findListBySubjectId(int sbjno) {
		List<StudentExVO> students = mapper.findListBySubjectId(sbjno);
		List<TaskVO> tasks = taskMap.findListBySubjectId(sbjno);
		List<AttendanceVO> attens = null;
		
		for(StudentExVO student : students) {
			attens = attenMap.findListByStudentIdAndSubjectId(student.getNo(), sbjno);
			student.setAttendanceList(attens);
			student.setGradeVO(gradeMap.findOneByStudentIdAndSubjectId(student.getNo(), sbjno));
			for(TaskVO task : tasks) {
				SubmitTaskVO subTask = taskMap.findSubmitTasksByTaskIdAndStudentId(task.getNo(), student.getNo());
				student.getSubmitTaskList().add(subTask);
			}
		}
		
		return students;
	}

}
