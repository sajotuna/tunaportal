package co.fourth.tuna.domain.lectureNotice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.common.service.FileService;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;

@Controller
public class LectureNoticeController {

	@Autowired
	SqlSession sql;
	@Autowired
	LectureNoticeService service;
//	
//	@RequestMapping("/eclass/student/lectureNotice")
//	public String lectureNotice(Model model, LectureNoticeVO vo) {
//		vo.setSbjNo(90079);
//		vo.setSeasonCode(105);
//		vo.setStNo(13168019);
//		List<Map<String, Object>> notice = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeList", vo);
//		
//		model.addAttribute("notice", notice);
//		
//		return "eclass/stud/lectureNotice";
//	}
//	
//	@RequestMapping("/eclass/student/lectureNoticeSelect")
//	public String lectureNoticeSelect(Model model, LectureNoticeVO vo) {
//		
//		vo.setStNo(13168019);
//		vo.setSeasonCode(105);
//		vo.setSbjNo(90079);
//		vo.setNo(1);
//		List<Map<String, Object>> ns = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeSelect", vo);
//		
//		System.out.println(ns);
//		
//		model.addAttribute("ns", ns);
//		
//		return "eclass/stud/lectureNoticeSelect";
//	}
//	

	@PostMapping("/prof/lecNotices")
	@ResponseBody
	public List<LectureNoticeVO> lectureNotices(@RequestBody Map<String, Integer> data) {
		// TODO 내 강의인지 확인
		return service.findListBySubjectId(data.get("sbjno"));
	}

	@PostMapping("/staff/eclass/notice")
	public String writeNotice(Authentication auth, LectureNoticeVO notice) {
		service.insertLectureNotice(notice);
		return "redirect:/eclass/professor/noticeList";
	}

	@RequestMapping("/eclass/professor/noticeUpdate")
	public String noticeUpdateView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "eclass/professor/noticeUpdate";
	}
	
	@RequestMapping("/eclass/professor/updateNotice")
	public String noticeUpdate(RedirectAttributes ra, LectureNoticeVO notice) {
		
		service.noticeUpdate(notice);
		ra.addFlashAttribute("success", "공지사항 수정이 완료되었습니다.");
		ra.addAttribute("no", notice.getNo());
		return "redirect:/eclass/professor/notice";
	}
	
	@ResponseBody
	@RequestMapping("/eclass/professor/noticeDelete")
	public int noticeDelete(@RequestBody LectureNoticeVO notice) {
		
		return service.noticeDelete(notice);
		
	}
	

}
