package co.fourth.tuna.domain.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentExVO extends StudentVO {
	
	private String stateName;
	private String bankName;
	private String deptName;
}
