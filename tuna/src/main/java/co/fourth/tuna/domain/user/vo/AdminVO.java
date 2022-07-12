package co.fourth.tuna.domain.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {
	private int no;
	private String pwd;
	private String name;
	private String email;
	private String stateCode;
	private String hireDate;
	private String role;
}
