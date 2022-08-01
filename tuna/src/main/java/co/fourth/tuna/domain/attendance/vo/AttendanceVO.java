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
	private Integer stNo;
	//인덱스
	private Integer no;
	//과목코드
	private Integer sbjNo;
	//날짜
	private Date classDate;
	//시즌코드
	private Integer seasonCode;
}
