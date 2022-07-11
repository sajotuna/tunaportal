package co.fourth.tuna.domain.tuition.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
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
}
