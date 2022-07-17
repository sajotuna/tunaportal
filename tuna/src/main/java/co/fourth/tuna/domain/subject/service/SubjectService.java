package co.fourth.tuna.domain.subject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface SubjectService {
	SubjectVO findOne(SubjectVO vo);
	
	public List<SubjectVO> findListForProfessorMain(ProfessorVO prof, int seasonCode, int pageNum, int size);
	public List<SubjectVO> SubjectCheck();
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key);
	
//	ArrayList<SubjectVO> getList(int pageNum, int size);
//	ArrayList<SubjectVO> getListByProf(ProfessorVO prof, int pageNum, int size);
//	
//	
//	List<Map<String, Object>> getMapsForLectureSchedule(int pageNum, int size);
//	List<Map<String, Object>> getMapsForLectureScheduleByProf(ProfessorVO prof, int pageNum, int size);
	
	
}
