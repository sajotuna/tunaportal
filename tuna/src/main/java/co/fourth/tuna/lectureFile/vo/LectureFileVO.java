package co.fourth.tuna.lectureFile.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureFileVO {
	private int no;
	private String title;
	private Date date;
	private String file;
	private String uri;
	private int sbjNo;
}
