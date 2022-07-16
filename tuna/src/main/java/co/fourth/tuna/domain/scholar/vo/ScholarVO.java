package co.fourth.tuna.domain.scholar.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScholarVO {
	private int no;
	private int name;
	private String docFlag;
	private int pct;
}
