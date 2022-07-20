package co.fourth.tuna.domain.tuition.vo;

import java.sql.Date;

import co.fourth.tuna.domain.scholar.vo.ScholarStudentVO;
import co.fourth.tuna.domain.scholar.vo.ScholarVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tuitionGiveVO {
	private int no;
	private String yn;
	private Date giveDate;
	private String seasonCode;
	private int scPct;
	private int stNo;
	private int scstNo;
	private int tuiNo;
	
	private StudentVO studentvo;
	private TuitionVO tuitionvo;
	private ScholarStudentVO scholarstudentvo;
	private ScholarVO scholarvo;
	
}
