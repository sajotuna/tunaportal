package co.fourth.tuna.domain.lectureEval.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureEvalVO {
	private Integer no;
	private String content;
	private double avgScore;
	private String stNo;
	private String sbjNo;
	private String evalState;
}
