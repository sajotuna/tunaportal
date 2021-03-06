package co.fourth.tuna.domain.user.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import co.fourth.tuna.domain.attendance.mapper.AttendanceMapper;
import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.mapper.GradeMapper;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.task.mapper.TaskMapper;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.domain.user.mapper.StudentMapper;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentWithSubjectsVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.domain.user.vo.StudentWithAttendanceVO;
import co.fourth.tuna.domain.user.vo.StudentWithSubmitTaskVO;

@Service
public class StudentServiceImpl implements StudentService, UserDetailsService {

	@Autowired
	private StudentMapper mapper;
	@Autowired
	private AttendanceMapper attenMap;
	@Autowired
	private TaskMapper taskMap;
	@Autowired
	private GradeMapper gradeMap;
	
	@Autowired
	private SubjectService subjectService;
	
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
			GradeVO grade = gradeMap.findOneByStudentIdAndSubjectId(student.getNo(), sbjno);
			//grade.setAttd(computeAttendanceScore(attens));
			
			student.setGradeVO(grade);
			for(TaskVO task : tasks) {
				SubmitTaskVO subTask = taskMap.findSubmitTasksByTaskIdAndStudentId(task.getNo(), student.getNo());
				if(student.getSubmitTaskList() != null) {
					student.getSubmitTaskList().add(subTask);
				} else {
					student.setSubmitTaskList(new ArrayList<SubmitTaskVO>());
					student.getSubmitTaskList().add(subTask);
				}
			}
		}
		
		return students;
	}
	

	@Override
	public void studPwdUpdate(StudentVO vo) {
		mapper.studPwdUpdate(vo);
		
	}
	
	@Override
	public StudentVO findByUserId(StudentVO vo) {
		// TODO Auto-generated method stub
		return mapper.findByUserId(vo);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentVO vo = new StudentVO();
		vo.setNo(Integer.parseInt(username));
		vo = mapper.findByUserId(vo);
		if(vo == null)
			throw new UsernameNotFoundException("no user");
		return vo;
	}

	@Override
	public String findStudPwd(StudentVO vo) {
		
		return mapper.findStudPwd(vo);
	}

	@Override
	public boolean findEmail(StudentVO vo) {
		// TODO Auto-generated method stub
		return mapper.findEmail(vo);
	}

	@Override
	public void studEamilPwdUpdate(StudentVO vo) {
		mapper.studEamilPwdUpdate(vo);
		
	}
	
	@Override
	public List<StudentWithSubmitTaskVO> findListWithSubmitTaskByTaskId(int taskno) {
		return mapper.findListWithSubmitTaskByTaskId(taskno);
	}

	@Override
	public void freshmanPwdUpdate(StudentVO vo) {
		mapper.freshmanPwdUpdate(vo);
		
	}

	@Override
	public List<StudentWithAttendanceVO> findStudentWithAttendanceListBySubjectIdAndDate(int sbjno, LocalDate date) {
		//LocalDate closetDate = attenMap.selectThisAttendanceBySubjectId(sbjno);
		List<StudentWithAttendanceVO> students = 
			mapper.findStudentWithAttendanceListBySubjectId(sbjno);
		for(StudentWithAttendanceVO stud : students) {
			stud.setAttendance(attenMap.findAttendanceByDateAndSubjectIdAndStudentId(date, sbjno, stud.getNo()));
		}
		
		return students;
	}

	@Override
	public StudentWithSubjectsVO getOneByStudentId(int stno, int pfno) {
		StudentWithSubjectsVO student = mapper.selectOneByStudentId(stno);
		student.setSubjectList(subjectService.getListByStudentIdAndProfessorId(stno, pfno));
		
		return student;
	}

	

	
	

}
