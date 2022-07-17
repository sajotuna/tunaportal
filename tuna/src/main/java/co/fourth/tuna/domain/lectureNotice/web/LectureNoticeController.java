package co.fourth.tuna.domain.lectureNotice.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;

@Controller
public class LectureNoticeController {

	@Autowired SqlSession sql;
	
	@RequestMapping("/eclass/student/lectureNotice")
	public String lectureNotice(Model model, LectureNoticeVO vo) {
		vo.setSbjNo(90079);
		vo.setSeasonCode(105);
		vo.setStNo(13168019);
		List<Map<String, Object>> notice = sql.selectList("co.fourth.tuna.domain.lectureNotice.mapper.LectureNoticeMapper.noticeList", vo);
		
		model.addAttribute("notice", notice);
		
		return "eclass/stud/lectureNotice";
	}
	
}
