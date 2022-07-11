package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskVO {
	private int no;
	private String title;
	private Date limitDate;
	private int sbjNo;
}
