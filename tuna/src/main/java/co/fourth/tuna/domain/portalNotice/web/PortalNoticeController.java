package co.fourth.tuna.domain.portalNotice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.portalNotice.service.PortalNoticeService;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

@Controller
public class PortalNoticeController {
	
	@Autowired
	private PortalNoticeService noticeDao;
	
	@RequestMapping("/portalNoticeList")
	public String portalnoticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeList(1, "전체"));
		return "notice/user/portalNoticeList";
	}
	
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/user/portalNoticeSelect";
	}
	
	
	@RequestMapping("/adminNoticeList")
	public String adminNoticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeList(1, "전체"));
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
