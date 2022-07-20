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

	@Override
	public String singleTwoTask(EclassStudentHomeVO vo) {
		return map.singleTwoTask(vo);
	}

	@Override
	public String singleTwoNotice(EclassStudentHomeVO vo) {
		return map.singleTwoNotice(vo);
	}

	@Override
	public String singleTwoQna(EclassStudentHomeVO vo) {
		return map.singleTwoQna(vo);
	}

	@Override
	public String singleTwoFile(EclassStudentHomeVO vo) {
		return map.singleTwoFile(vo);
	}

}
