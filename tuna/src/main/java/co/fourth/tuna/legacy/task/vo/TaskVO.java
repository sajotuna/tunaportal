package co.fourth.tuna.legacy.task.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskVO {
	private int no;
	private String title;
	private Date limitDate;
	private int sbjNo;
}
