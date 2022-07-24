package co.fourth.tuna.domain.subject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.common.mapper.LectureScheduleMapper;
import co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.subject.mapper.GradeRatioMapper;
import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectMapper map;
	@Autowired
	LectureScheduleMapper lectureScheduleMap;
	@Autowired
	GradeRatioMapper gradeRatioMap;
	@Autowired
	LecturePlanMapper planMap;
	
	@Autowired
	LecturePlanService lecPlanService;
	
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

	@Override
	public SubjectVO findOneWithApplysAndRatioAndFilesById(int no) {
		return map.findOneWithApplysAndRatioAndFilesById(no);
	}

	@Override
	public SubjectVO findOneWithRatioAndScheduleAndPlanById(int no) {
		SubjectVO subject = map.findOneById(no);
		subject.setLectureScheduleList(lectureScheduleMap.findLectureScheduleForSubjectId(no));
		subject.setGradeRatioVO(gradeRatioMap.findOneById(no));
		subject.setLecturePlanList(planMap.findListBySubjectId(no));
		return subject;
	}

	@Override
	@Transactional
	public String updateGradeRatio(GradeRatioVO gradeRatio) {
		int sum = gradeRatio.getAttd() + gradeRatio.getFinals() + gradeRatio.getMiddle() + gradeRatio.getTask();
		
		if(sum < 100 || sum > 100) {
			throw new Error("평가기준 합계가 100이 되어야 합니다.");
		}
		
		if(gradeRatioMap.updateGradeRatioByNo(gradeRatio) < 1) {
			throw new Error("오류가 발생 했습니다."); 
		}
		
		return "성공";
	}

	@Override
	@Transactional(rollbackFor = Error.class)
	public String updateSubject(GradeRatioVO grade, List<LecturePlanVO> plans) {		
		lecPlanService.updatePlanList(plans);
		this.updateGradeRatio(grade);
//		return new ServiceResponseVO(ResState.ERROR, e.getMessage());
	
		return "성공적으로 업데이트 되었습니다.";
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
