package co.fourth.tuna.domain.attendance.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceVO {
	private int no;
	private String state;
	private Date classDate;
	private int stNo;
	private int sbjNo;
}
