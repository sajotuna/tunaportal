package co.fourth.tuna.domain.common.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceAndDateVO {
	private String roomCode;
	private String roomName;
	
	@JsonFormat(pattern="yy-MM-dd", timezone="Asia/Seoul")
	private LocalDate localDate;
}
