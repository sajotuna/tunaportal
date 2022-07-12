package co.fourth.tuna.domain.user.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
