package co.fourth.tuna.domain.objection.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectionVO {
	private int no;
	private Date enrollDate;
	private String content;
	private String answer;
	private Date answerDate;
	private String seasonCode;
	private int stNo;
	private int sbjNo;
}
