package co.fourth.tuna.domain.tuition.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TuitionVO {
	private int no;
	private String seasonCode;
	private String deptCode;
	private int amount;
}
