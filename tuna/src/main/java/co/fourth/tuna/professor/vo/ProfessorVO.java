package co.fourth.tuna.professor.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
