package co.fourth.tuna.domain.user.mapper;

import java.util.List;

import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

public interface StudentMapper {
	public StudentVO findById(StudentVO vo);

	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	public StudentVO findOneById(int no);
	public void studPwdUpdate(StudentVO vo);
	public StudentVO findByUserId(StudentVO vo);
	public String findStudPwd(StudentVO vo);
	public boolean findEmail(StudentVO vo);
	public void studEamilPwdUpdate(StudentVO vo);
	//TODO 사용자 가져올 때 비밀번호 제외
	public List<StudentExVO> findListBySubjectId(int sbjno);
}
