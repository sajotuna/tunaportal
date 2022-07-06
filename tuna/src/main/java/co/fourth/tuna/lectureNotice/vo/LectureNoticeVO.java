package co.fourth.tuna.lectureNotice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date date;
	private int sbjNo;
}
