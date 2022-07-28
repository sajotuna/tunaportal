package co.fourth.tuna.domain.task.vo;

import co.fourth.tuna.domain.user.vo.StudentWithSubjectsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EclassStudentDetailPageVO {
	private String msg;
	
	private StudentWithSubjectsVO student;
}
