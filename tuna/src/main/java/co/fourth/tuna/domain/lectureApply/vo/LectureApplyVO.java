package co.fourth.tuna.domain.lectureApply.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureApplyVO {
	private int no;
	private String seasonCode;
	private int stNo;
	private int sbjNo;
	

}
