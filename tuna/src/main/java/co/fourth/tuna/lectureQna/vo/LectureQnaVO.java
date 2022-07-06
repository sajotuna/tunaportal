package co.fourth.tuna.lectureQna.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureQnaVO {
	private int no;
	private String title;
	private String content;
	private Date date;
	private String answer;
	private Date answerDate;
	private int stNo;
	private int sbjNo;
}
