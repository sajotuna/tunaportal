package co.fourth.tuna.domain.student.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
	private int no;
	private int pwd;
	private String email;
	private String name;
	private String tel;
	private String zip;
	private String addr;
	private int sy;
	private String stateCode;
	private Date birth;
	private String bacc;
	private String bank;
	private String deptCode;
	private Date enterDate;
	private String role;
}
