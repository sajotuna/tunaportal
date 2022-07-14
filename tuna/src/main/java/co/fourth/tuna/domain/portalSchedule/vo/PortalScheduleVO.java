package co.fourth.tuna.domain.portalSchedule.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PortalScheduleVO {
	private String no;
	private String month;
	
	private String content;
	private String seasonCode;
	private String adNo;
	
	@JsonFormat(pattern = "yyyy/MM/dd",timezone="Asia/Seoul")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy/MM/dd",timezone="Asia/Seoul")
	private Date endDate;
}
