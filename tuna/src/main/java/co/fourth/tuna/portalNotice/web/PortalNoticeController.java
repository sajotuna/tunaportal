package co.fourth.tuna.portalNotice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalNoticeController {
	
	@RequestMapping("/portalNoticeList")
	public String portalnoticeList() {
		return "portal/extra/portalNoticeList";
	}
	
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect() {
		return "portal/extra/portalNoticeSelect";
	}
}
