package co.fourth.tuna.domain.lectureNotice.vo;

import java.sql.Date;

import co.fourth.tuna.domain.subject.vo.SubjectVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private int sbjNo;
	private int stNo;
	private int seasonCode;
	private int rowNum;
	
	private SubjectVO subjectVO;
}
