package co.fourth.tuna.domain.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.student.mapper.StudentMapper;
import co.fourth.tuna.domain.student.service.StudentService;
import co.fourth.tuna.domain.student.vo.StudentVO;

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