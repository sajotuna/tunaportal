package co.fourth.tuna.submitTask.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitTaskVO {
	private int no;
	private String file;
	private String uri;
	private Date date;
	private int score;
	private int stNo;
	private int taskNo;
}
