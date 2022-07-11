package co.fourth.tuna.domain.attendance.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceVO {
	private int no;
	private String state;
	private Date classDate;
	private int stNo;
	private int sbjNo;
}
