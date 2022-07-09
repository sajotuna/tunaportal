package co.fourth.tuna.legacy.lectureNotice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private int sbjNo;
}
