package co.fourth.tuna.domain.task.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskVO {
	
	//인덱스
	private int no;
	//제목
	private String title;
	//제출기한
	private Date limitDate;
	//과목코드
	private int sbjNo;
	//시작시간
	private Date startDate;
	
	
	private List<SubmitTaskVO> submitTaskList;
}
