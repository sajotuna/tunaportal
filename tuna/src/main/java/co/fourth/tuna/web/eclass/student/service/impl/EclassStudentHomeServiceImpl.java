package co.fourth.tuna.web.eclass.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper;
import co.fourth.tuna.web.eclass.student.service.EclassStudentHomeService;
import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

@Service
public class EclassStudentHomeServiceImpl implements EclassStudentHomeService {

	@Autowired
	EclassStudentHomeMapper map;
	
	@Override
	public EclassStudentHomeVO subList(EclassStudentHomeVO vo) {
		return map.subList(vo);
	}

	@Override
	public String twoTask(EclassStudentHomeVO vo) {
		return map.twoTask(vo);
	}

}
