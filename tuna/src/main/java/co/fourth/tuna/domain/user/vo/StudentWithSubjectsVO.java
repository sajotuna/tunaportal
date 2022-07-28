package co.fourth.tuna.domain.user.vo;

import java.util.List;

import co.fourth.tuna.domain.subject.vo.SubjectWithAttendanceVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithSubjectsVO extends StudentVO {
	private String deptName;
	
	private List<SubjectWithAttendanceVO> subjectList;
}
