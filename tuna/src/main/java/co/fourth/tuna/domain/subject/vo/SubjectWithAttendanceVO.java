package co.fourth.tuna.domain.subject.vo;

import java.util.List;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.task.vo.SubmitTaskWithTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectWithAttendanceVO extends SubjectVO{
	
	private List<AttendanceVO> attendanceList;
	private GradeVO grade;
	private List<SubmitTaskWithTaskVO> submitTaskList;
	private List<LectureQnaVO> qnaList;
}
