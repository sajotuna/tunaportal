package co.fourth.tuna.domain.common.vo.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureScheduleVO {
	private int no;
	private String dayCode;
	private String roomCode;
	private String timeCode;
	private int sbjNo;
}
