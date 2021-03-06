package co.fourth.tuna.domain.grade.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;

public interface GradeService {
	
	public List<Map<String, Object>> currentSemesterGradeSelect(int stNo, String seasonCode);
	public Map<String, Object> currentSemesterGradeTotal(int stNo, String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(int stNo, String SeasonCode);
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(int stNo, String SeasonCode);
	
	public String updateTaskGradeByStudentIdAndSubjectId(int stNo, int sbjNo);
	
	public String updateGradeByGradeNo(GradeFormVO vo);
	public String updateGradeByStudentNoAndSubjectNo(GradeFormVO vo);
	public String updateGradeListByGradeNo(List<GradeFormVO> vo);
	public String updateGradeListByStudentNoAndSbjectNo(List<GradeFormVO> vo);
	
	public String updateSubmitTaskGrade(EclassSubmitTaskScoreForm form);
	public String updateAttendanceTaskGrade(int sbjno, int stno);
	public GradeVO getOneByStudentIdAndSubjectId(int stno, int sbjno);
	
	public int computeTotalScore(int sbjno, int stno);
	
	public int computeAttendanceScore(List<AttendanceVO> attends);
	public String scoreLimitFilter(GradeFormVO vo);
	
	public GradeRatioVO getGradeRatioBySubjectId(int sbjno);
}
