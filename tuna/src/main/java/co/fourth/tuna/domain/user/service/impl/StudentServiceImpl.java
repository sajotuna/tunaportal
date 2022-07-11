package co.fourth.tuna.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.user.mapper.StudentMapper;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;
	
	@Override
	public StudentVO findById(StudentVO vo) {
		// TODO Auto-generated method stub
		return mapper.findById(vo);
	}

}