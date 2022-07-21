package co.fourth.tuna.domain.objection.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.fourth.tuna.domain.grade.vo.GradeVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectionVO {
	private int no;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date enrollDate;
	private String content;
	private String answer;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date answerDate;
	private String seasonCode;
	private int stNo;
	private int sbjNo;
	
	GradeVO grade;
	StudentVO student;
	
	private String objState;
}
