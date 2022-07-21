package co.fourth.tuna.util;

import org.springframework.stereotype.Service;

public class CustomDateUtills {
	
	public static int koreanWeeksToLocalDateNum(String korDay) {
		
		switch(korDay) {
		case "월":
			return 1;
		case "화":
			return 2;
		case "수":
			return 3;
		case "목":
			return 4;
		case "금":
			return 5;
		case "토":
			return 6;
		case "일":
			return 7;
		default :
			return -1;
		}
	}
	
}
