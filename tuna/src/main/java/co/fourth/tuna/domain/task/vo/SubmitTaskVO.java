package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubmitTaskVO {
	private int no;
	private String fileName;
	private String uri;
	private Date enrollDate;
	private int score;
	private int stNo;
	private int taskNo;
}
