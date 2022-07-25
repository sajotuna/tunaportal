package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitTaskVO {
	private Integer no;
	private String fileName;
	private String uri;
	private Date enrollDate;
	private Integer score;
	private Integer stNo;
	private Integer taskNo;
}
