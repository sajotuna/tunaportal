package co.fourth.tuna.domain.grade.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeVO {
	private int no;
	private int middle;
	private int finals;
	private int attd;
	private int task;
	private int total;
	private int stNo;
	private int sbjNo;
}
