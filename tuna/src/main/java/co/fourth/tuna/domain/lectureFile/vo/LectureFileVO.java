package co.fourth.tuna.domain.lectureFile.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class LectureFileVO {
	private Integer no;
	private String title;
	private Date enrollDate;
	private String fileName;
	private String uri;
	private Integer sbjNo;
}
