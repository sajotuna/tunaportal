package co.fourth.tuna.domain.grade.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeFormVO {
	private Integer no;
	private Integer middle;
	private Integer finals;
	private Integer attd;
	private Integer task;
	private Integer total;
	private Integer stNo;
	private Integer sbjNo;
}
