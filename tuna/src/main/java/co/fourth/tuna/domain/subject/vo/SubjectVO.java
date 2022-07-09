package co.fourth.tuna.domain.subject.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectVO {
	private int no;
	private String group;
	private String name;
	private int target;
	private String type;
	private int point;
	private int limit;
	private String deptCode;
	private String seasonCode;
	private int pfNo;
}
