package co.fourth.tuna.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.user.mapper.StudentMapper;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;
	
	@Override
	public StudentVO findById(StudentVO vo) {
		return mapper.findById(vo);
	}

	@Override
	public void studUpdate(StudentVO vo) {
		mapper.studUpdate(vo);
	}

	@Override
	public void AdminStudUpdate(StudentVO vo) {
		mapper.AdminStudUpdate(vo);
	}

	@Override
	public List<StudentExVO> findListBySubjectId(int sbjno) {
		return mapper.findListBySubjectId(sbjno);
	}

}
