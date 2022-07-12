package co.fourth.tuna.domain.banner.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerVO {
	private int no;
	private String bannerCode;
	private Date enrollDate;
	private Date startDate;
	private Date endDate;
	private String fileName;
	private String uri;
	private String url;
	private int sequence;
	private String adNo;
}
