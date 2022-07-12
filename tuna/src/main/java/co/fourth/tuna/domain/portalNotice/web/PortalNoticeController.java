package co.fourth.tuna.domain.portalNotice.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.portalNotice.service.PortalNoticeService;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

@Controller
public class PortalNoticeController {

	@Autowired
	private PortalNoticeService noticeDao;

	@Autowired
	private String saveDir;

	// student
	@RequestMapping("/stud/portalNoticeList")
	public String portalnoticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeList(1, "전체"));
		return "notice/user/portalNoticeList";
	}

	@RequestMapping("/stud/portalNoticeSelect")
	public String portalNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/user/portalNoticeSelect";
	}

	
	
	@RequestMapping("/adminNoticeList")
	public String adminNoticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeList(1, "전체"));
		return "notice/admin/adminNoticeList";
	}

	@RequestMapping("/admin/adminNoticeSelect")
	public String adminNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		return "notice/admin/adminNoticeSelect";
	}

	@RequestMapping("/admin/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "notice/admin/adminNoticeInsert";
	}

	@PostMapping("/admin/adminNoticeInsert")
	public String adminNoticeInsert(PortalNoticeVO vo, PortalNoticeFileVO fileVo, MultipartFile[] files)
			throws IOException {

		noticeDao.noticeInsert(vo);

		for (MultipartFile file : files) {

			String fileName = file.getOriginalFilename();
			if (fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
				String uid = UUID.randomUUID().toString();
				String saveFileName = uid + fileName.substring(fileName.indexOf("."));

				File target = new File(saveDir, saveFileName);

				fileVo.setName(fileName);
				fileVo.setUri(saveFileName);
				fileVo.setPnno(vo.getNo());

				noticeDao.fileInsert(fileVo);
			}

		}
		return "redirect:/admin/adminNoticeList";
	}

	@RequestMapping("/admin/adminNoticeUpdate")
	public String adminNoticeUpdate() {
		return "notice/admin/adminNoticeUpdate";
	}

	@PostMapping("/admin/adminSearch")
	@ResponseBody
	public List<PortalNoticeVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		return noticeDao.noticeList(state, key);
	}

}
