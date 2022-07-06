package co.fourth.tuna.banner.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerVO {
	private int no;
	private String bannerCode;
	private Date date;
	private Date start;
	private Date end;
	private String file;
	private String uri;
	private int adNo;
}
