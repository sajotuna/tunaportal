package co.fourth.tuna.domain.lectureQna.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;

@Controller
public class LectureQnaController {

	@Autowired SqlSession sql;
	@Autowired LectureQnaService lecQnaService;
	
	@PostMapping("/staff/lecQna")
	@ResponseBody
	public List<LectureQnaVO> getLectureQna(
			@RequestBody Map<String, Integer>reqData) {
		return lecQnaService.findListBySubjectId(reqData.get("sbjno"));
	}
	
	@PostMapping("/staff/lecQnaAnswer")
	public String lecQnaAnswer(LectureQnaVO qna,RedirectAttributes ra) {
		
		lecQnaService.professorQnaUpdate(qna);
		
		ra.addAttribute("no", qna.getNo());
		ra.addFlashAttribute("success", "답변 작성이 완료되었습니다.");
		
		return "redirect:/staff/lecQna";
		
	}
}
