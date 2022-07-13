package co.fourth.tuna.domain.common.vo;

import lombok.Data;

@Data
public class PagingVO {
	private int length;
	private int pageCount;
	private int sizePerPage;
	private String tableName;
}
