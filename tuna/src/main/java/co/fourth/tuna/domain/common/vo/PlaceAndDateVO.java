package co.fourth.tuna.domain.common.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceAndDateVO {
	private String roomCode;
	private String roomName;
	private LocalDate localDate;
}
