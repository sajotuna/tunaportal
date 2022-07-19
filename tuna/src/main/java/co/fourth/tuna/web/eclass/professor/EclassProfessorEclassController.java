package co.fourth.tuna.web.eclass.professor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.common.service.CodeService;
import co.fourth.tuna.domain.common.service.PagingService;
import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.lectureNotice.service.LectureNoticeService;
import co.fourth.tuna.domain.lectureNotice.vo.LectureNoticeVO;
import co.fourth.tuna.domain.lectureQna.service.LectureQnaService;
import co.fourth.tuna.domain.lectureQna.vo.LectureQnaVO;
import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;


@Controller
@RequestMapping("/eclass/professor")
public class EclassProfessorEclassController {
	
	@Autowired PagingService pagingService;
	@Autowired SubjectService subjectService;
	@Autowired LectureQnaService lectureService;
	@Autowired LectureNoticeService noticeService;
	
	@Autowired CodeService codeService;
	
	private String profPath = "eclass/professor";
	
	private static final Logger logger = LoggerFactory.getLogger(EclassProfessorEclassController.class);
	
	@GetMapping(value = {"", "/", "/home"})
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
		
		//TODO 교수 데이터 추가해야함
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(63123);
		//TODO 기준 시즌 필요
		int season = 106;
		
		List<SubjectVO> subList = subjectService.findListForProfessorMain(prof, season, 1, 5);
		List<LectureQnaVO> qnaList = lectureService.findByProfessor(prof, 1, 5); 
		List<LectureNoticeVO> noticeList = noticeService.findByProfessor(prof, 1, 5);
		
		model.addAttribute("subList", subList);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("noticeList",noticeList);
		
		return profPath + "/home";
	}
	
	@GetMapping("/notice")
	public String noticeView(
			Model model, 
			HttpServletRequest req,
			@RequestParam(value="no")int no){
		
		model.addAttribute("notice", noticeService.findById(no));
		
		return req.getServletPath();
	}
	
	@GetMapping("/noticeForm")
	public String noticeFormView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/noticeList")
	public String noticeListView(
			Model model, 
			HttpServletRequest req,
			@RequestParam(value="pageNum", required=false, defaultValue= "1" ) int pageNum) {
		//TODO 교수 데이터 추가해야함
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(61275);
		
		List<LectureNoticeVO> noticeList = noticeService.findByProfessor(prof, pageNum, 20);
		List<LectureNoticeVO> noticeList2 = noticeService.findByProfessor(prof, pageNum, 999);
		int pageCount = (int)Math.ceil((double)noticeList2.size()/(20+1));
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageCount", pageCount);
		
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
	public String subjectView(
			Model model, 
			HttpServletRequest req,
			@RequestParam(value="no", required = false, defaultValue = "0")int no ) {
		if(no < 1) {
			return "redirect:/"+profPath;
		}
		SubjectVO subject = subjectService.findOneWithApplysAndRatioAndFilesById(no);
		model.addAttribute("subject", subject);
		
		return req.getServletPath();
	}
	
	@GetMapping("/subjectForm")
	public String subjectFormView(Model model, HttpServletRequest req) {
		return req.getServletPath();
	}
	
	@GetMapping("/subjectList")
	public String subjectListView(
			Model model, 
			HttpServletRequest req, 
			@RequestParam(value="season", required=false, defaultValue= "0" ) int season) {

		//TODO 교수 데이터 추가해야함
		ProfessorVO prof = new ProfessorVO();
		prof.setNo(61275);
		
		if(season == 0) {
			season = 105;
		}
		
		CodeMasterVO seasonMasterCode = codeService.findById("100");
		
		List<SubjectVO> subList = subjectService.findListForProfessorMain(prof, season, 1, 999);

		model.addAttribute("subList", subList);
		model.addAttribute("seasonCodes", seasonMasterCode);
		model.addAttribute("selectedSeason", season);
		return req.getServletPath();
	}
	
	
}
