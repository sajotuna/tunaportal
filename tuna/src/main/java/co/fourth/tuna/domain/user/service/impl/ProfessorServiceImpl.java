package co.fourth.tuna.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.user.mapper.ProfessorMapper;
import co.fourth.tuna.domain.user.service.ProfessorService;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired 
	private ProfessorMapper mapper;
	
	@Override
	public ProfessorVO findById(ProfessorVO vo) {
		return mapper.findById(vo);
	}

	@Override
	public void profUpdate(ProfessorVO vo) {
		mapper.profUpdate(vo);
	}

	@Override
	public void AdminProfUpdate(ProfessorVO vo) {
		mapper.AdminProfUpdate(vo);
	}

}
