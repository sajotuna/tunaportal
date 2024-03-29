package co.fourth.tuna.domain.scholar.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<ScholarApplyVO> scholarApplyCheck(ScholarApplyVO vo) {
		return mapper.scholarApplyCheck(vo);
	}

	@Override
	public void scholarCheckUpdate(ScholarApplyVO vo) {
		mapper.scholarCheckUpdate(vo);
	}

	@Override
	public void scholarSuccessUpdate(ScholarApplyVO vo) {
		mapper.scholarSuccessUpdate(vo);
	}

	@Override
	public void scholarStudentGiveMoney(ScholarApplyVO vo) {
		mapper.scholarStudentGiveMoney(vo);
		
	}

	@Override
	public int scholarApplyCount(Map<String, Object> params) {
		return mapper.scholarApplyCount(params);
	}

	@Override
	public List<Map<String, Object>> adminScholarCheck(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return mapper.adminScholarCheck(params);
	}

	@Override
	public List<Map<String, Object>> ScholarCheck(ScholarApplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.ScholarCheck(vo);
	}
	
	
}
