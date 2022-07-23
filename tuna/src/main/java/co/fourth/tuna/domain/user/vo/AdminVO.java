package co.fourth.tuna.domain.user.vo;

import java.sql.Date;

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
	private Date hireDate;
	private String role;
	private String tel;
	private String addr;
	private String deptcode;
	private String zip;
	
}
