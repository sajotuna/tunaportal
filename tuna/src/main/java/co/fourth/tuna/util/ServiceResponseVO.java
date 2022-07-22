package co.fourth.tuna.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponseVO {
	private ResState state;
	private String message;
}
