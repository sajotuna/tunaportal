package co.fourth.tuna.domain.user.service;

import java.time.LocalDate;
import java.util.List;

import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.domain.user.vo.StudentWithAttendanceVO;
import co.fourth.tuna.domain.user.vo.StudentWithSubmitTaskVO;

public interface StudentService {

	public StudentVO findById(StudentVO vo);
	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	public void studPwdUpdate(StudentVO vo);
	public List<StudentExVO> findListBySubjectId(int sbjno);
	public List<StudentWithAttendanceVO> findStudentWithAttendanceListBySubjectIdAndDate(int sbjno, LocalDate date);
	public List<StudentWithSubmitTaskVO> findListWithSubmitTaskByTaskId(int taskno);
	public StudentVO findByUserId(StudentVO vo);
	public String findStudPwd(StudentVO vo);
	public boolean findEmail(StudentVO vo);
	public void studEamilPwdUpdate(StudentVO vo);
	public void freshmanPwdUpdate(StudentVO vo);
	
}
