package co.fourth.tuna.domain.scholar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.scholar.mapper.ScholarMapper;
import co.fourth.tuna.domain.scholar.service.ScholarService;
import co.fourth.tuna.domain.scholar.vo.ScholarApplyVO;
import co.fourth.tuna.domain.scholar.vo.ScholarVO;


@Service
public class ScholarServiceImpl implements ScholarService {
	
	@Autowired
	private ScholarMapper mapper;

	@Override
	public void ScholarApply(ScholarApplyVO vo) {
		mapper.ScholarApply(vo);
	}

	@Override
	public List<ScholarVO> FindScholar(ScholarVO vo) {
		return mapper.FindScholar(vo);
	}

	@Override
	public List<ScholarApplyVO> ScholarCheck(ScholarApplyVO vo) {
		return mapper.ScholarCheck(vo);
	}

	@Override
	public void FileUpLoad(ScholarApplyVO vo) {
		mapper.FileUpLoad(vo);
	}
	@Override
	public void ScholarDelete(ScholarApplyVO vo) {
		mapper.ScholarDelete(vo);
	}

	@Override
	public void scholarUpdate(ScholarApplyVO vo) {
		mapper.scholarUpdate(vo);
	}
	
	
}
