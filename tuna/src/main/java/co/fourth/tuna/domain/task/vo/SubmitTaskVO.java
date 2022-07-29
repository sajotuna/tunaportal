package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitTaskVO {
	private Integer no;
	private String fileName;
	private String uri;
	private Date enrollDate;
	private Integer score;
	private Integer stNo;
	private Integer taskNo;
}
