package co.fourth.tuna.domain.grade.service;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.vo.GradeFormVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.subject.vo.GradeRatioVO;
import co.fourth.tuna.domain.task.vo.EclassSubmitTaskScoreForm;
import co.fourth.tuna.util.CustomException;
import co.fourth.tuna.util.ResponseMsg;

public interface GradeService {
	
	public List<Map<String, Object>> currentSemesterGradeSelect(int stNo, String seasonCode);
	public Map<String, Object> currentSemesterGradeTotal(int stNo, String seasonCode);
	public List<Map<String, Object>> subjectGradeSelect(int stNo, String SeasonCode);
	public List<Map<String, Object>> seasonSubjectGradeSelect(int stNo, String seasonCode);
	public List<Map<String, Object>> avgGradeSelect(int stNo, String SeasonCode);
	
	public ResponseMsg updateTaskGradeByStudentIdAndSubjectId(int stNo, int sbjNo) throws CustomException;
	
	public ResponseMsg updateGradeByGradeNo(GradeFormVO vo) throws CustomException;
	public ResponseMsg updateGradeByStudentNoAndSubjectNo(GradeFormVO vo) throws CustomException;
	public ResponseMsg updateGradeListByGradeNo(List<GradeFormVO> vo) throws CustomException;
	public ResponseMsg updateGradeListByStudentNoAndSbjectNo(List<GradeFormVO> vo) throws CustomException;
	
	public ResponseMsg updateSubmitTaskGrade(EclassSubmitTaskScoreForm form) throws CustomException;
	public ResponseMsg updateAttendanceTaskGrade(int sbjno, int stno) throws CustomException;
	public GradeVO getOneByStudentIdAndSubjectId(int stno, int sbjno);
	
	public int computeTotalScore(int sbjno, int stno);
	
	public int computeAttendanceScore(List<AttendanceVO> attends);
	public Boolean scoreLimitFilter(GradeFormVO vo);
	
	public GradeRatioVO getGradeRatioBySubjectId(int sbjno);
}
