package co.fourth.tuna.domain.portalNotice.vo;

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
