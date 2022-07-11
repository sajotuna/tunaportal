package co.fourth.tuna.domain.scholar.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScholarApplyVO {
	private int no;
	private Date applyDate;
	private Date confirmDate;
	private String stateCode;
	private String fileName;
	private String uri;
	private String seasonCode;
	private int stNo;
	private int schNo;
}
