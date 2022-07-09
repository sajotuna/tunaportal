package co.fourth.tuna.legacy.portalNotice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortalNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date date;
	private String visible;
	private int adNo;
}
