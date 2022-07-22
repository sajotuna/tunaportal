package co.fourth.tuna.util;

public enum ResState {
	SUCESS(10, "성공"),
	ERROR(40, "에러")
	;
	
	
	private final int code;
	private final String label;
	
	ResState(int code, String label) {
		this.code = code;
		this.label = label;
	}
	
	public int code() {
		return code;
	}
	
	public String label() {
		return label;
	}
}
