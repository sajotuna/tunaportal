package co.fourth.tuna.legacy.professor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.legacy.professor.mapper.ProfessorMapper;
import co.fourth.tuna.legacy.professor.service.ProfessorService;
import co.fourth.tuna.legacy.professor.vo.ProfessorVO;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired 
	private ProfessorMapper mapper;
	
	@Override
	public ProfessorVO findById(ProfessorVO vo) {
		return mapper.findById(vo);
	}

}
