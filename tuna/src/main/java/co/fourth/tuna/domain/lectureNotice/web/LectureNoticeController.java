package co.fourth.tuna.domain.lectureNotice.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;

@Controller
public class LectureNoticeController {

	@Autowired SqlSession sql;
	@Autowired LectureNoticeService service;
	
	@RequestMapping("/eclass/student/lectureNotice")
	public String lectureNotice(Model model, LectureNoticeVO vo) {
		vo.setSbjNo(90079);
		vo.setSeasonCode(105);
		vo.setStNo(13168019);
		List<Map<String, Object>> notice = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeList", vo);
		
		model.addAttribute("notice", notice);
		
		return "eclass/stud/lectureNotice";
	}
	
	@RequestMapping("/eclass/student/lectureNoticeSelect")
	public String lectureNoticeSelect(Model model, LectureNoticeVO vo) {
		
		vo.setStNo(13168019);
		vo.setSeasonCode(105);
		vo.setSbjNo(90079);
		vo.setNo(1);
		List<Map<String, Object>> ns = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeSelect", vo);
		
		model.addAttribute("ns", ns);
		
		return "eclass/stud/lectureNoticeSelect";
	}
	
	
	@PostMapping("/lecNotices")
	@ResponseBody
	public List<LectureNoticeVO> lectureNotices(@RequestBody Map<String,Integer> data) {
		// TODO 내 강의인지 확인
		return service.findListBySubjectId(data.get("sbjno"));
	}
}
