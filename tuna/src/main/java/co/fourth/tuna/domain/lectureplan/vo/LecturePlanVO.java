package co.fourth.tuna.domain.lectureplan.vo;

import java.util.List;

import co.fourth.tuna.domain.common.vo.PlaceAndDateVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturePlanVO {
	private int no;
	private String wkCode;
	private String summary;
	private int sbjNo;
	
	private List<PlaceAndDateVO> placeAndDate;
}
