package co.fourth.tuna.domain.lectureEval.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureEvalVO {
	private int no;
	private String content;
	private int avgScore;
	private int stNo;
	private int sbjNo;
	private String docFlag;
}
