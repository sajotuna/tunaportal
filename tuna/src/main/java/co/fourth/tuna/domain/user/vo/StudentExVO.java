package co.fourth.tuna.domain.user.vo;

import java.util.List;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.task.vo.SubmitTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentExVO extends StudentVO {
	
	private String stateName;
	private String bankName;
	private String deptName;
	
	private GradeVO gradeVO;
	private List<AttendanceVO> attendanceList;
	private List<SubmitTaskVO> submitTaskList;
	private List<LectureQnaVO> lectureQnaList;
}
