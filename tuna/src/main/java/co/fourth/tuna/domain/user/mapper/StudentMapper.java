package co.fourth.tuna.domain.user.mapper;

import co.fourth.tuna.domain.user.vo.StudentVO;

public interface StudentMapper {
	public StudentVO findById(StudentVO vo);
	public void studUpdate(StudentVO vo);
}
