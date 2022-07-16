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
	
	@Override
	public SubjectVO findOne(SubjectVO vo) {
		return map.findOne(vo);
	}

	@Override
	public List<SubjectVO> findListForProfessorMain(ProfessorVO prof, int seasonCode, int pageNum, int size) {
		return map.findListForProfessorMain(prof, seasonCode, pageNum, size);
	}
	@Override
	public List<SubjectVO> SubjectCheck(){
		return map.SubjectCheck();
	}

	@Override
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key) {
		return map.searchSubjectList(seasonCode, searchKey, key);
	}
	
	
	
//	
//	@Override
//	public ArrayList<SubjectVO> getList(int start, int size) {
//		return null;
//	}
//	@Override
//	public ArrayList<SubjectVO> getListByProf(ProfessorVO prof, int start, int size) {
//		return null;
//	}
//
//	@Override
//	public List<Map<String, Object>> getMapsForLectureSchedule(int pageNum, int size) {
//		Map<String, Object> params = new HashMap<>();
//		
//		params.put("pageNum", pageNum);
//		params.put("size", size);
//		
//		List<Map<String, Object>> result = sqlSession.selectList(SubjectMapper.class.getName()+".findListForLectureSchedule", params);
//		
//		return result;
//	}
//
//
//	@Override
//	public List<Map<String, Object>> getMapsForLectureScheduleByProf(ProfessorVO prof, int pageNum, int size) {
//		Map<String, Object> params = new HashMap<>();
//		
//		params.put("pageNum", pageNum);
//		params.put("size", size);
//		params.put("prof", prof);
//		
//		List<Map<String, Object>> result = sqlSession.selectList(SubjectMapper.class.getName()+".findListForLectureScheduleByProf", params); 
//		
//		return result;
//	}
	
	
}
