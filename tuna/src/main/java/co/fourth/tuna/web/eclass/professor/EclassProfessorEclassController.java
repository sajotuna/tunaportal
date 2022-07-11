package co.fourth.tuna.web.eclass.professor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/eclass/professor")
public class EclassProfessorEclassController {
	
	//private String profPath = "/eclass/professor";
	
	private static final Logger logger = LoggerFactory.getLogger(EclassProfessorEclassController.class);
	
	@GetMapping(value = {"/", "/home"})
	public String homeView(Model model, HttpServletRequest req) {
//		logger.info(req.getRequestURI()); //tuna/eclass/professor/notice
//		logger.info(req.getRequestURL().toString()); //http://localhost/tuna/eclass/professor/notice
//		logger.info(req.getServletPath()); //eclass/professor/notice
		return req.getServletPath();
	}
	
	@GetMapping("/notice")
	public String noticeView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/noticeForm")
	public String noticeFormView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/noticeList")
	public String noticeListView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/noticeUpdate")
	public String noticeUpdateView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/qna")
	public String qnaView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/qnaList")
	public String qnaListView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/studentList")
	public String studentListView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/subject")
	public String subjectView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/subjectForm")
	public String subjectFormView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/subjectList")
	public String subjectListView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	
	
	
	
}
