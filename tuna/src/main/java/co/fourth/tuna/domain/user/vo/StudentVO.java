package co.fourth.tuna.domain.user.vo;

import java.sql.Date;

import co.fourth.tuna.domain.scholar.vo.ScholarStudentVO;
import co.fourth.tuna.domain.scholar.vo.ScholarVO;
import co.fourth.tuna.domain.tuition.vo.TuitionVO;
import co.fourth.tuna.domain.tuition.vo.tuitionGiveVO;
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
	
	private TuitionVO tuitionvo;
	private ScholarStudentVO scholarstudentvo;
	private ScholarVO scholarvo;
	private tuitionGiveVO tuitionGivevo;
	
}
