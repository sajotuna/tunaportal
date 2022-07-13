package co.fourth.tuna.web.eclass.professor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.domain.common.service.PagingService;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;


@Controller
@RequestMapping("/eclass/professor")
public class EclassProfessorEclassController {
	
	@Autowired
	PagingService pagingService;
	
	@Autowired
	SubjectService subjectService;
	
	private String profPath = "/eclass/professor";
	
	private static final Logger logger = LoggerFactory.getLogger(EclassProfessorEclassController.class);
	
	@GetMapping(value = {"/", "/home"})
	public String homeView(Model model, HttpServletRequest req) {
//		logger.info(req.getRequestURI()); //tuna/eclass/professor/notice
//		logger.info(req.getRequestURL().toString()); //http://localhost/tuna/eclass/professor/notice
//		logger.info(req.getServletPath()); //eclass/professor/notice
		
//		PagingVO paging = new PagingVO();
//		System.out.println("!! here");
//		paging.setTableName("subject");
//		paging.setSizePerPage(10);
//		paging = pagingService.getPaging(paging);
//		System.out.println(paging.getLength());
		
		// TODO 교수 데이터 추가해야함
		
		//List<Map<String,Object>> subList = subjectService.getMapsForLectureScheduleByProf(prof,1, 5);
		
//		SubjectVO subject = new SubjectVO();
//		subject.setNo(18011);
//		subject = subjectService.findListForProfessorMainByProf(prof);
//		System.out.println("!!!here!!!");
//		System.out.println(subject.getLectureScheduleList().get(0).getNo());
//		System.out.println(subject.getLectureScheduleList().get(1).getNo());
//		
//		System.out.println("!!!lectureApply!!!");
//		System.out.println(subject.getLectureApplyList().get(0).getNo());
//		System.out.println(subject.getLectureApplyList().get(1).getNo());
//		//System.out.println(subList.get(0));
//		System.out.println("!!!lectureQna!!!");
//		System.out.println(subject.getLectureQnaList().get(0).getNo());
		
		
		return profPath + "/home";
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
		//TODO 교수 데이터 추가해야함
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(61275);
		
		ArrayList<SubjectVO> subList = subjectService.findListForProfessorMainByProf(prof);
		
		model.addAttribute("subList", subList);
		return req.getServletPath();
	}
	
	
	
}
