package co.fourth.tuna.legacy.banner.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerVO {
	private int no;
	private String bannerCode;
	private Date enrollDate;
	private Date startDate;
	private Date endDate;
	private String fileName;
	private String uri;
	private int adNo;
}
