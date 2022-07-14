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
	private String no;
	private String seasonCode;
	private String stNo;
	private String sbjNo;
	
	private String stateCode;
	

}
