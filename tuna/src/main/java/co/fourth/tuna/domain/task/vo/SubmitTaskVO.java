package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitTaskVO {
	private int no;
	private String fileName;
	private String uri;
	private Date enrollDate;
	private int score;
	private int stNo;
	private int taskNo;
}
