package co.fourth.tuna.domain.subject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeRatioVO {
	private int no;
	private int middle;
	private int finals;
	private int task;
	private int attd;
}
