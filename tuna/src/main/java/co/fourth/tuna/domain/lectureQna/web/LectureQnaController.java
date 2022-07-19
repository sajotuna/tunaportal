package co.fourth.tuna.domain.lectureQna.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;

@Controller
public class LectureQnaController {

	@Autowired SqlSession sql;
	
	@RequestMapping("/eclass/student/qnaList")
	public String qnaList(Model model, LectureQnaVO vo) {
		
		vo.setSbjNo(18011);
		List<Map<String, Object>> qna = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", vo);
		
		model.addAttribute("qna", qna);
		
		System.out.println(qna);
		
		return "eclass/stud/qnaList";
	}
	
	@RequestMapping("eclass/student/qnaSelect")
	public String qnaSelect(Model model, LectureQnaVO vo) {
		
		vo.setNo(1);
		vo.setSbjNo(18011);
		vo.setStNo(13168019);
		List<Map<String, Object>> qs = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaSelect", vo);
		
		System.out.println(qs);
		model.addAttribute("qs", qs);
		
		return "eclass/stud/qnaSelect";
	}
	
}
