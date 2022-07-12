package co.fourth.tuna.domain.subject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectMapper map;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public SubjectVO findOne(SubjectVO vo) {
		return null;
	}


	@Override
	public ArrayList<SubjectVO> getList(int start, int size) {
		return null;
	}
	@Override
	public ArrayList<SubjectVO> getListByProf(ProfessorVO prof, int start, int size) {
		return null;
	}

	@Override
	public List<Map<String, Object>> getMapsForLectureSchedule(int pageNum, int size) {
		HashMap params = new HashMap();
		
		params.put("pageNum", pageNum);
		params.put("size", size);
		
		List<Map<String, Object>> result = sqlSession.selectList(SubjectMapper.class.getName()+".findListForLectureSchedule", params); 
		
		return result;
	}


	@Override
	public List<Map<String, Object>> getMapsForLectureScheduleByProf(ProfessorVO prof, int pageNum, int size) {
		HashMap params = new HashMap();
		
		params.put("pageNum", pageNum);
		params.put("size", size);
		params.put("prof", prof);
		
		List<Map<String, Object>> result = sqlSession.selectList(SubjectMapper.class.getName()+".findListForLectureScheduleByProf", params); 
		
		return result;
	}
	
	
	
}
