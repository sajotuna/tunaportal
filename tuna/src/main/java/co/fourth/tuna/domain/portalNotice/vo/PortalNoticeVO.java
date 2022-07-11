package co.fourth.tuna.domain.portalNotice.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PortalNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private String visible;
	private int adNo;
}
