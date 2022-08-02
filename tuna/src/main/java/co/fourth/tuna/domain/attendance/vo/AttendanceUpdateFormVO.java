package co.fourth.tuna.domain.attendance.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceUpdateFormVO {
	Integer stno;
	Integer sbjno;
	List<AttendanceVO> attendanceList;
}
