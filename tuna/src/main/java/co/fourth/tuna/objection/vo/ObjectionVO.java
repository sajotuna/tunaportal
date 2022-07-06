package co.fourth.tuna.objection.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectionVO {
	private int no;
	private Date date;
	private String content;
	private String answer;
	private Date answerDate;
	private String seasonCode;
	private int stNo;
	private int sbjNo;
}
