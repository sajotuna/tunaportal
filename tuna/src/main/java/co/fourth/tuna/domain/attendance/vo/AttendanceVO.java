package co.fourth.tuna.domain.attendance.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceVO {
	//출결상태
	private String stateCode;
	//학번
	private int stNo;
	//인덱스
	private int no;
	//과목코드
	private int sbjNo;
	//날짜
	private Date classDate;
}
