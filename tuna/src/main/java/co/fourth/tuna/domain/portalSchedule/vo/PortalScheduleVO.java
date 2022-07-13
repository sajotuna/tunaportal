package co.fourth.tuna.domain.portalSchedule.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PortalScheduleVO {
	private int no;
	private Date startDate;
	private Date endDate;
	private String content;
	private String seasonCode;
	private int adNo;
}
