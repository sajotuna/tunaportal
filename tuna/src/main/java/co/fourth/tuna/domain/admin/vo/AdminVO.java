package co.fourth.tuna.domain.admin.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminVO {
	private int no;
	private String pwd;
	private String name;
	private String email;
	private String stateCode;
	private String hireDate;
	private String role;
}
