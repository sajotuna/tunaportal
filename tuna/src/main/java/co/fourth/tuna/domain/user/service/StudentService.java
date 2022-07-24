package co.fourth.tuna.domain.user.service;

import java.util.List;

import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.domain.user.vo.StudentWithSubmitTaskVO;

public interface StudentService {

	public StudentVO findById(StudentVO vo);
	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	public void studPwdUpdate(StudentVO vo);
	public List<StudentExVO> findListBySubjectId(int sbjno);
	public List<StudentWithSubmitTaskVO> findListWithSubmitTaskByTaskId(int taskno);
	public StudentVO findByUserId(StudentVO vo);
	public String findStudPwd(StudentVO vo);
	public boolean findEmail(StudentVO vo);
	public void studEamilPwdUpdate(StudentVO vo);
}
