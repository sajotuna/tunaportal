package co.fourth.tuna.domain.lectureQna.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureQnaVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private String answer;
	private Date answerDate;
	private int stNo;
	private int sbjNo;
}
