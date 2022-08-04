package co.fourth.tuna.domain.subject.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.fourth.tuna.domain.attendance.service.AttendanceService;
import co.fourth.tuna.domain.common.mapper.LectureScheduleMapper;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.grade.service.GradeService;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureplan.mapper.LecturePlanMapper;
import co.fourth.tuna.domain.lectureplan.service.LecturePlanService;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.subject.mapper.GradeRatioMapper;
import co.fourth.tuna.domain.subject.mapper.SubjectMapper;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.subject.vo.SubjectWithAttendanceVO;
import co.fourth.tuna.domain.task.service.TaskService;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.util.CustomDateUtills;

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
	@Autowired
	YearService yearService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	GradeService gradeService;
	@Autowired
	TaskService taskService;
	@Autowired
	LectureQnaService lecQnaService;
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectService.class);
	
	@Override
	public SubjectVO findOne(SubjectVO vo) {
		return map.findOne(vo);
	}
	
	@Override
	public List<SubjectVO> findListByProfessorVO(ProfessorVO prof) {
		return map.findListByProfessorVO(prof, Integer.parseInt( yearService.yearFind() ) );
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
	public String updateGradeRatio(GradeRatioVO gradeRatio) throws Error {
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
	public String updateSubject(GradeRatioVO grade, List<LecturePlanVO> plans) throws Error {		
		lecPlanService.updatePlanList(plans);
		subjectService.updateGradeRatio(grade);
		// TODO 트랜잭션 https://ppqqpqpq.tistory.com/60
//		return new ServiceResponseVO(ResState.ERROR, e.getMessage());
	
		return "성공적으로 업데이트 되었습니다.";
	}

	@Override
	public List<SubjectWithAttendanceVO> getListByStudentIdAndProfessorId(int stno, int pfno) {
		String season =  yearService.yearFind();
		List<SubjectWithAttendanceVO> subjectList = map.selectListByStudentIdAndPrfessorId(stno, pfno, season);
		for(SubjectWithAttendanceVO subject : subjectList) {
			subject.setAttendanceList(attendanceService.getListByStudentIdAndSbjno(stno, subject.getNo()));
			subject.setGrade(gradeService.getOneByStudentIdAndSubjectId(stno, subject.getNo()));
			subject.setSubmitTaskList(taskService.getSubmitTaskWithTaskListByStudentIdAndSubjectId(stno, subject.getNo()));
			subject.setQnaList(lecQnaService.getListByStudentIdAndSubjectId(stno, subject.getNo()));
		}
		return subjectList;
  }

	public int subjectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return map.subjectCount(params);

	}

	@Override
	public Integer thisWeekCalculator(
			List<LecturePlanVO> plans, 
			List<LectureScheduleVO> schedule, 
			LocalDate startDate) {
		
		LocalDate tempDate = startDate;
		LocalDate today = LocalDate.now();
		
		for( int i = 0; i < plans.size(); i++ ) {
			for( LectureScheduleVO lecSche : schedule ) {
				LocalDate ldate = tempDate.with(
					TemporalAdjusters.next(
						DayOfWeek.of(CustomDateUtills.koreanWeeksToLocalDateNum(lecSche.getDayCode()))
					)
				);
				tempDate = tempDate.plusWeeks(i);
				
				if(today.compareTo(ldate) < 0) return i;
			}
		}
		
		return null;
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
