package co.fourth.tuna.scholarApply.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScholarApplyVO {
	private int no;
	private Date applyDate;
	private Date confirmDate;
	private String stateCode;
	private String fileName;
	private String uri;
	private String seasonCode;
	private int stNo;
	private int adNo;
	private int schNo;
}
