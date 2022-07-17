package co.fourth.tuna.domain.user.service;

import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface ProfessorService {

	public ProfessorVO findById(ProfessorVO vo);
	public void profUpdate(ProfessorVO vo);
	public void AdminProfUpdate(ProfessorVO vo);
	
}
