package co.fourth.tuna.domain.lectureFile.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureFileVO {
	private int no;
	private String title;
	private Date enrollDate;
	private String fileName;
	private String uri;
	private int sbjNo;
}
