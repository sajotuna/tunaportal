package co.fourth.tuna.legacy.portalNotice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalNoticeController {
	
	@RequestMapping("/portalNoticeList")
	public String portalnoticeList() {
		return "notice/user/portalNoticeList";
	}
	
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect() {
		return "notice/user/portalNoticeSelect";
	}
	
	@RequestMapping("/adminNoticeList")
	public String adminNoticeList() {
		return "notice/admin/adminNoticeList";
	}
	
	@RequestMapping("/adminNoticeInsert")
	public String adminNoticeInsert() {
		return "notice/admin/adminNoticeInsert";
	}
	
	@RequestMapping("/adminNoticeUpdate")
	public String adminNoticeUpdate() {
		return "notice/admin/adminNoticeUpdate";
	}
	
	
}
