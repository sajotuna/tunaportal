package co.fourth.tuna.domain.subject.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

public interface SubjectService {
	public SubjectVO findOne(SubjectVO vo);
	public SubjectVO findOneWithApplysAndRatioAndFilesById(int no);
	public SubjectVO findOneWithRatioAndScheduleAndPlanById(int no);
	
	public List<SubjectVO> findListByProfessorVO(ProfessorVO prof);
	public List<SubjectVO> findListForProfessorMain(ProfessorVO prof, int seasonCode, int pageNum, int size);
	public List<SubjectVO> SubjectCheck();
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key);
	public int subjectCount();
//	ArrayList<SubjectVO> getList(int pageNum, int size);
//	ArrayList<SubjectVO> getListByProf(ProfessorVO prof, int pageNum, int size);
//	
//	
//	List<Map<String, Object>> getMapsForLectureSchedule(int pageNum, int size);
//	List<Map<String, Object>> getMapsForLectureScheduleByProf(ProfessorVO prof, int pageNum, int size);
	
	@Transactional(rollbackFor = {Error.class, Exception.class})
	public String updateSubject(GradeRatioVO grade, List<LecturePlanVO> plans);
	@Transactional
	public String updateGradeRatio(GradeRatioVO grade);
	

}
