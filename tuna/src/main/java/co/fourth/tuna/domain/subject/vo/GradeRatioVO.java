package co.fourth.tuna.domain.subject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeRatioVO {
	private int no;
	private int middle;
	private int finals;
	private int task;
	private int attd;
}
