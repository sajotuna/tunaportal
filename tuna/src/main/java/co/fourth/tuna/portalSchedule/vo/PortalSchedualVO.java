package co.fourth.tuna.portalSchedule.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortalSchedualVO {
	private int no;
	private Date start;
	private Date end;
	private String content;
	private String seasonCode;
	private int adNo;
}