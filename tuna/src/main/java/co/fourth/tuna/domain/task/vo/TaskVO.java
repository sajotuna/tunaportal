package co.fourth.tuna.domain.task.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskVO {
	
	//인덱스
	private int no;
	//제목
	private String title;
	//제출기한
	private Date limitDate;
	//과목코드
	private int sbjNo;
}
