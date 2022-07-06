package co.fourth.tuna.tuitionGive.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class tuitionGiveVO {
	private int no;
	private String yn;
	private Date date;
	private String seasonCode;
	private String deptCode;
	private int scPct;
	private int stNo;
	private int scstNo;
	private int tuiNo;
}
