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
	private String proname;
	
//	private SubjectVO subject;
	private String group;
	private String name;
	private int target;
	private String type;
	private int point;
	private int limit;
	private String deptCode;
	private int pfNo;
//	private LectureScheduleVO Schedule;
	
	private String dayCode;
	private String roomCode;
	private String timeCode;

}
