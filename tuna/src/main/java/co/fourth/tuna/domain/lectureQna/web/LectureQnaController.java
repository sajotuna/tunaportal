package co.fourth.tuna.domain.lectureQna.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;

@Controller
public class LectureQnaController {

	@Autowired SqlSession sql;
	
//	@RequestMapping("/eclass/student/qnaList")
//	public String qnaList(Model model, @RequestParam HashMap<String, Object> map, @RequestParam(value="pageNum", required=false, defaultValue= "1" ) int pageNum) {
//		
//		map.put("sbjNo", 18011);
//		map.put("pageNum", pageNum);
//		map.put("size", 5);
//		List<Map<String, Object>> qna = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", map);
//		
//		map.put("sbjNo", 18011);
//		map.put("pageNum", pageNum);
//		map.put("size", 100);
//		List<Map<String, Object>> qna2 = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaList", map);
//		
//		int pageCount = (int)Math.ceil((double)qna2.size()/(5));
//		
//		model.addAttribute("qna", qna);
//		model.addAttribute("pgcnt", pageCount);
//		
//		System.out.println(qna);
//		
//		return "eclass/stud/qnaList";
//	}
//	
//	@RequestMapping("eclass/student/qnaSelect")
//	public String qnaSelect(Model model, LectureQnaVO vo) {
//		
//		vo.setNo(1);
//		vo.setSbjNo(18011);
//		vo.setStNo(13168019);
//		List<Map<String, Object>> qs = sql.selectList("co.fourth.tuna.domain.lectureQna.mapper.LectureQnaMapper.qnaSelect", vo);
//		
//		System.out.println(qs);
//		model.addAttribute("qs", qs);
//		
//		return "eclass/stud/qnaSelect";
//	}
	
}
