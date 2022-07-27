package co.fourth.tuna.domain.user.vo;

import co.fourth.tuna.domain.attendance.vo.AttendanceVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithAttendanceVO extends StudentVO {
	
	private String stateName;
	private String bankName;
	private String deptName;
	
	private AttendanceVO attendance;
}
