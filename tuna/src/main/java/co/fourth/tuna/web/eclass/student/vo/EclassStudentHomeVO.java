package co.fourth.tuna.web.eclass.student.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EclassStudentHomeVO {

	//학번
	private Integer no;
	//연도학기
	private Integer seasonCode;
	//과목이름
	private String sbjName;
	//과목코드
	private Integer sbjNo;
}
