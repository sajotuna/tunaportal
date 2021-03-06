package co.fourth.tuna.domain.subject.vo;

import java.util.Date;
import java.util.List;

import co.fourth.tuna.domain.common.vo.subject.LectureScheduleVO;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureFile.vo.LectureFileVO;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.lectureplan.vo.LecturePlanVO;
import co.fourth.tuna.domain.objection.vo.ObjectionVO;
import co.fourth.tuna.domain.task.vo.TaskVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVO {
	private int no;
	private String group;
	private String name;
	private int target;
	private String type;
	private int point;
	private int limit;
	private String deptCode;
	private String seasonCode;
	private int pfNo;

	private ProfessorVO professorVO;
	private GradeRatioVO gradeRatioVO;

	private Date start;
	private Date end;

	// private List<AttendanceVO> attendanceList;
	private List<LectureApplyVO> lectureApplyList; // 수강생
	private List<LectureQnaVO> lectureQnaList; // 문의
//	private List<LectureEvalVO> lectureEvalList; // 강의평가
	private List<ObjectionVO> objectionList; // 이의
	private List<TaskVO> taskList; // 과제
	private List<LectureFileVO> lectureFileList; // 파일
//	private List<LectureNoticeVO> lectureNoticeList; // 공지
	private List<LectureScheduleVO> lectureScheduleList; // 강의 스케줄
	private List<LecturePlanVO> lecturePlanList;
}
