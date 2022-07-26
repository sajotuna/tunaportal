package co.fourth.tuna.domain.portalNotice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.common.service.PagingService;
import co.fourth.tuna.domain.common.vo.ListPagingVO;
import co.fourth.tuna.domain.common.vo.PagingVO;
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
	@Autowired
	PagingService pagingDao;

	// user
	// 전체조회
	@RequestMapping("/portalNoticeList")
	public String portalnoticeList(Model model, PortalNoticeVO vo,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {

		ListPagingVO pvo = new ListPagingVO();
		pvo.pageInfo(page, range, noticeDao.getNoticeCnt("Y"), 10, 10);
		

		List<PortalNoticeVO> notices = noticeDao.adminNoticeList(1, "전체", pvo.getStartList(), pvo.getEndList());

		model.addAttribute("notices", notices);
		model.addAttribute("paging", pvo);
		

		return "notice/user/portalNoticeList";

	}

	// 단건조회
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));

		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/user/portalNoticeSelect";
	}

	// admin
	// 전체조회
	@RequestMapping("/admin/admin/adminNoticeList")
	public String adminNoticeList(Model model, PortalNoticeVO vo,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {

		/*
		 * NoticePagingVO nvo = new NoticePagingVO();
		 * 
		 * PagingVO pvo = pagingDao.getPaging(new PagingVO("portalNotice", 10));
		 * 
		 * nvo.pageInfo(page, range, pvo.getPageCount(), 10, nvo.getListSize());
		 */
		
		ListPagingVO pvo = new ListPagingVO();
		pvo.pageInfo(page, range, noticeDao.getNoticeCnt("N"), 10, 10);
		

		List<PortalNoticeVO> notices = noticeDao.adminNoticeList(1, "전체", pvo.getStartList(), pvo.getEndList());

		model.addAttribute("notices", notices);
		model.addAttribute("paging", pvo);
		

		return "notice/admin/adminNoticeList";
	}

	// 단건조회
	@RequestMapping("/admin/admin/adminNoticeSelect")
	public String adminNoticeSelect(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));

		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/admin/adminNoticeSelect";
	}

	// 공지등록폼
	@RequestMapping("/admin/admin/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "notice/admin/adminNoticeInsert";
	}

	
	// Editor 이미지 업로드
	@PostMapping("/ckImage")
	@ResponseBody
	public Map<String, String> ckfinderImage(MultipartHttpServletRequest request) throws Exception {
		
		MultipartFile image = request.getFile("upload");
		Map<String, String> result = new HashMap<>();
		
		String[] fileInfo = fileService.upload(image, "PortalNotice/image");
		
		result.put("uploaded", "true");
		result.put("url", "/tuna/display?fileName=" + fileInfo[1] + "&folder=PortalNotice");
		
		return result;

	}

	// 공지등록
	@PostMapping("/admin/admin/adminNoticeInsert")
	public String adminNoticeInsert(PortalNoticeVO vo, PortalNoticeFileVO fileVo, Authentication authentication,
			@RequestParam(value = "file") MultipartFile[] files) throws IOException {

		
		vo.setAdNo((authentication.getName()));
		noticeDao.noticeInsert(vo);

		logger.info("insert 확인" + vo);
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
		return "redirect:/admin/admin/adminNoticeList";
	}

	// 공지수정폼
	@PostMapping("/admin/admin/adminNoticeupdateForm")
	public String adminNoticeUpdateForm(PortalNoticeVO vo, Model model) {
		model.addAttribute("content", noticeDao.noticeSelect(vo));
		model.addAttribute("files", noticeDao.fileSelect(Integer.parseInt(vo.getNo())));

		return "notice/admin/adminNoticeUpdate";
	}

	// 공지 수정
	@PostMapping("/admin/admin/adminNoticeUpdate")
	public String adminNoticeUpdate(PortalNoticeVO vo, Authentication authentication,
			@RequestParam(value = "file") MultipartFile[] files) throws IOException {

		vo.setAdNo((authentication.getName()));
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

		return "redirect:/admin/admin/adminNoticeList";

	}


	// 파일삭제
	@DeleteMapping("/fileDel")
	@ResponseBody
	public int fileDelete(@RequestBody PortalNoticeFileVO fileVo) {
		fileService.delete(fileVo.getUri(), "PortalNotice");
		return noticeDao.fileDelete(fileVo);
	}

	// 공지삭제
	@DeleteMapping("/admin/admin/adminNoticeDelete")
	@ResponseBody
	public int adminNoticeDelete(@RequestBody PortalNoticeVO vo) {

		List<PortalNoticeFileVO> list = noticeDao.fileSelect(Integer.parseInt(vo.getNo()));

		logger.info("list ::" + list.toString());

		for (int i = 0; i < list.size(); i++) {
			logger.info("uri ::" + list.get(i).getUri());
			fileService.delete(list.get(i).getUri(), "portalNotice");
		}

		return noticeDao.noticeDelete(vo);

	}

	// 공지검색
	@GetMapping("/admin/admin/adminSearch")
	@ResponseBody
	public List<PortalNoticeVO> adminSearch(@RequestParam("state") int state, @RequestParam("key") String key,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {

		int size = 10;
		return noticeDao.adminNoticeList(state, key, pageNum, size);
	}

}
