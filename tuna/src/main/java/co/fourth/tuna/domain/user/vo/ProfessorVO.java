package co.fourth.tuna.domain.user.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorVO {
	private int no;
	private String pwd;
	private String email;
	private String name;
	private String tel;
	private String addr;
	private String stateCode;
	private String zip;
	private Date hireDate;
	private String role;
	private String deptcode;
}
