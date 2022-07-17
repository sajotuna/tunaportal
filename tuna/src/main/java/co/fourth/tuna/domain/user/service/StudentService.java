package co.fourth.tuna.domain.user.service;

import co.fourth.tuna.domain.user.vo.StudentVO;

public interface StudentService {

	public StudentVO findById(StudentVO vo);
	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	
}
