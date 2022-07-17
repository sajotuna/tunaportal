package co.fourth.tuna.domain.scholar.vo;

import java.sql.Date;

import co.fourth.tuna.domain.user.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScholarApplyVO {
	private String no;
	private Date applyDate;
	private Date confirmDate;
	private String stateCode;
	private String fileName;
	private String uri;
	private String seasonCode;
	private String stNo;
	private String schNo;
	
	private ScholarVO scholarVO;
	private StudentVO studentVO;
}
