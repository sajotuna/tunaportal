package co.fourth.tuna.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
@RequestMapping("/adminNoticeList")
public String adminNoticeList() {
	return "portal/admin/adminNoticeList";
}

@RequestMapping("/adminNoticeInsert")
public String adminNoticeInsert() {
	return "portal/admin/adminNoticeInsert";
}

@RequestMapping("/adminNoticeUpdate")
public String adminNoticeUpdate() {
	return "portal/admin/adminNoticeUpdate";
}

@RequestMapping("/adminSchedule")
public String adminSchedule() {
	return "portal/admin/adminSchedule";
}

}
