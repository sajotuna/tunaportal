package co.fourth.tuna.domain.user.service;

import java.util.List;

import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

public interface StudentService {

	public StudentVO findById(StudentVO vo);
	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	
	public List<StudentExVO> findListBySubjectId(int sbjno);
}
