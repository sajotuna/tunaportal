package co.fourth.tuna.domain.user.mapper;

import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface ProfessorMapper {
	public ProfessorVO findById(ProfessorVO vo);
	public void profUpdate(ProfessorVO vo);
	public void AdminProfUpdate(ProfessorVO vo);
	public void staffEamilPwdUpdate(ProfessorVO vo);
	public void staffPwdUpdate(ProfessorVO vo);
	public String findStaffPwd(ProfessorVO vo);
}
