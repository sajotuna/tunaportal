package co.fourth.tuna.domain.lectureBasket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LectureBasketVO {
	private int no;
	private String stateCode;
	private int seasonCode;
	private int sbjNo;
	private int stNo;
}
