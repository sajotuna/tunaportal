package co.fourth.tuna.domain.banner.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
