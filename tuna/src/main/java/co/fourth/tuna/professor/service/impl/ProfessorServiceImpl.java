package co.fourth.tuna.professor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.professor.mapper.ProfessorMapper;
import co.fourth.tuna.professor.service.ProfessorService;
import co.fourth.tuna.professor.vo.ProfessorVO;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired 
	private ProfessorMapper mapper;
	
	@Override
	public ProfessorVO findById(ProfessorVO vo) {
		return mapper.findById(vo);
	}

}
