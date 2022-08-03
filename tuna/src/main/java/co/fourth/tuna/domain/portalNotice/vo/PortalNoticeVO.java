package co.fourth.tuna.domain.portalNotice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalNoticeVO {
	private String no;
	private String title;
	private String content;
	private String visible;
	private String adNo;	
	private String fileyn;
	private String hit;
	private int next;
	private int last;
	private String nexttitle;
	private String lasttitle;
		
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	private Date enrollDate;


	
}
