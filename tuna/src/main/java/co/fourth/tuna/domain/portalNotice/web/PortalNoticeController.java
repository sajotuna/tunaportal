package co.fourth.tuna.domain.portalNotice.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.portalNotice.service.PortalNoticeService;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeFileVO;
import co.fourth.tuna.domain.portalNotice.vo.PortalNoticeVO;

@Controller
public class PortalNoticeController {

	private static Logger logger = LoggerFactory.getLogger(PortalNoticeController.class);

	@Autowired
	private PortalNoticeService noticeDao;

	@Autowired
	private FileService fileService;

	// user
	// 전체조회
//	@RequestMapping("/portalNoticeList")
//	public String portalnoticeList(Model model, PortalNoticeFileVO fileVo) {
//		
//		model.addAttribute("notices", noticeDao.noticeList(1, "전체", 2, 10));
//
//		List<PortalNoticeFileVO> list = noticeDao.fileList(fileVo);
//		Set<String> fileYn = new HashSet<>();
//		for (PortalNoticeFileVO vo : list) {
//			fileYn.add(vo.getPnno());
//		}
//		return "notice/user/portalNoticeList";
//
//	}

	// 단건조회
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));

		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/user/portalNoticeSelect";
	}

	// admin
	// 전체조회
	@RequestMapping("/admin/adminNoticeList")
	public String adminNoticeList(Model model, PortalNoticeVO vo, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		
		int size = 10;
		

		model.addAttribute("notices", noticeDao.noticeList(1, "전체", pageNum, size));
		
		List<PortalNoticeFileVO> list = noticeDao.fileList();
		Set<String> fileYn = new HashSet<>();
		for (PortalNoticeFileVO fvo : list) {
			fileYn.add(fvo.getPnno());
		}
		
		model.addAttribute("files", fileYn);
		return "notice/admin/adminNoticeList";
	}


	// 단건조회
	@RequestMapping("/admin/adminNoticeSelect")
	public String adminNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));

		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/admin/adminNoticeSelect";
	}

	// 공지등록폼
	@RequestMapping("/admin/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "notice/admin/adminNoticeInsert";
	}

	// 공지등록
	@PostMapping("/admin/adminNoticeInsert")
	public String adminNoticeInsert(PortalNoticeVO vo, PortalNoticeFileVO fileVo,
			@RequestParam(value = "file") MultipartFile[] files) throws IOException {

		noticeDao.noticeInsert(vo);

		for (MultipartFile file : files) {

			String originName = file.getOriginalFilename();

			if (originName != null && originName.length() != 0) {
				String[] portalFile = fileService.upload(file, "PortalNotice");

				fileVo.setName(portalFile[0]);
				fileVo.setUri(portalFile[1]);
				fileVo.setPnno(vo.getNo());
				noticeDao.fileInsert(fileVo);
			}

		}
		return "redirect:/admin/adminNoticeList";
	}

	// 공지수정폼
	@PostMapping("/admin/adminNoticeupdateForm")
	public String adminNoticeUpdateForm(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/admin/adminNoticeUpdate";
	}

	// 공지 수정
	@PostMapping("/admin/adminNoticeUpdate")
	public String adminNoticeUpdate(PortalNoticeVO vo, @RequestParam(value = "file") MultipartFile[] files)
			throws IOException {

		noticeDao.noticeUpdate(vo);

		for (MultipartFile file : files) {

			String originName = file.getOriginalFilename();

			if (originName != null && originName.length() != 0) {
				String[] portalFile = fileService.upload(file, "PortalNotice");
				PortalNoticeFileVO fileVo = new PortalNoticeFileVO();
				fileVo.setPnno(vo.getNo());
				fileVo.setName(portalFile[0]);
				fileVo.setUri(portalFile[1]);

				noticeDao.fileInsert(fileVo);
			}
		}

		return "redirect:/admin/adminNoticeList";

	}

	// 파일삭제
	@DeleteMapping("/fileDel")
	@ResponseBody
	public int fileDelete(@RequestBody PortalNoticeFileVO fileVo) {
		fileService.delete(fileVo.getUri(), "PortalNotice");
		return noticeDao.fileDelete(fileVo);
	}

	// 공지삭제
	@DeleteMapping("/admin/adminNoticeDelete")
	@ResponseBody
	public int adminNoticeDelete(@RequestBody PortalNoticeVO vo) {
		
		List<PortalNoticeFileVO> list = noticeDao.fileSelect(Integer.parseInt(vo.getNo()));
		
		logger.info("list ::" + list.toString());	
		
		for(int i=0; i<list.size(); i++) {
			logger.info("uri ::" + list.get(i).getUri());	
			fileService.delete(list.get(i).getUri(), "portalNotice");
		}
		
		
			
		return noticeDao.noticeDelete(vo);

	}

	// 공지검색
	@GetMapping("/admin/adminSearch")
	@ResponseBody
	public List<PortalNoticeVO> adminSearch(@RequestParam("state") int state, @RequestParam("key") String key,
			@RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		
		int size = 10;		
		return noticeDao.noticeList(state, key, pageNum, size);
	}

}
