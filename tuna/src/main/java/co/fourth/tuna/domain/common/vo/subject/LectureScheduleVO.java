package co.fourth.tuna.domain.common.vo.subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureScheduleVO {
	private int no;
	private String dayCode;
	private String roomCode;
	private String timeCode;
	private int sbjNo;
}
