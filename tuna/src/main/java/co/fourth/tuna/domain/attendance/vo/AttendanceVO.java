package co.fourth.tuna.domain.attendance.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceVO {
	private String stateCode;
	private int stNo;
	private int no;
	private int sbjNo;
	private Date classDate;
}
