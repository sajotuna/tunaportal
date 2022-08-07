package co.fourth.tuna.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg {
	
	public static final String SUCCESS = "success";
	public static final String CHECK_CONFIRM = "checkConfirm";
	public static final String WARNING_CONFIRM = "warnConfirm";
	public static final String ERROR = "error";
	public static final String INFO = "info";
	public static final String QUESTION = "question";
	
	private String title;
	private String msg;
	
	private String type;
}
