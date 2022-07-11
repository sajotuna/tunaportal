package co.fourth.tuna.domain.lectureNotice.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private int sbjNo;
}
