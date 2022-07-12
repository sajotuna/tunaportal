package co.fourth.tuna.domain.portalNotice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PortalNoticeVO {
	private int no;
	private String title;
	private String content;
	private String visible;
	private String adNo;	
		
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	private Date enrollDate;


	
}
