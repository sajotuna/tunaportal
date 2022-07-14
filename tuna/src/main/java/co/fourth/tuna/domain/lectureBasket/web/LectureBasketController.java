package co.fourth.tuna.domain.lectureBasket.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;

@Controller
public class LectureBasketController {

	@Autowired
	private SqlSession SqlSession;
	@Autowired
	private LectureBasketService LectureBasketDao;

	@RequestMapping("/stud/courseBasket")
	public String courseBasket(Model model, LectureBasketVO vo, Authentication authentication, String pageNum, 
							  @RequestParam(value="deptCode", required=false ) String deptCode,
							  @RequestParam(value="type", required=false) String type,
							  @RequestParam(value="target", required=false) String target,
							  @RequestParam(value="name", required=false) String name) {
		Map<String, Object> params = new HashMap<>();

		if (pageNum == null) {
			params.put("pageNum", 1);
		} else {
			params.put("pageNum", pageNum);
		}
		
		System.out.println(deptCode);
		System.out.println(type);
		System.out.println(target);
		System.out.println(name);
		params.put("deptCode",deptCode);
		params.put("type",type);
		params.put("target",target);
		params.put("name",name);

		params.put("size", 10);

		vo.setStNo(authentication.getName());
		List<Map<String, Object>> lists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.SubjectFind", params);
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo.getStNo());

		model.addAttribute("list", lists);
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasket";
	}

	@RequestMapping("/stud/basketInsert")
	public String basketInsert(RedirectAttributes ra, @RequestParam List<String> courcheck, LectureBasketVO vo,
			Authentication authentication) {
		
		vo.setStNo(authentication.getName());
		int checkCount = 0;
		for (String sbj : courcheck) {
			String[] sbjarr = sbj.split(",");
			
			if(sbjarr.length <= 2) {
				System.out.println(courcheck.toString().substring(1, courcheck.toString().length()-1));
				sbjarr = courcheck.toString().substring(1, courcheck.toString().length()-1).split(",");
				checkCount +=1;
			}
			vo.setSbjNo(sbjarr[0]);
			vo.setSeasonCode(sbjarr[1]);
			if (sbjarr[2].indexOf("/") != -1) {
				String[] day = sbjarr[2].split("/");
				String[] dayTime = sbjarr[3].split(" ");
				String[] time = null;
				int cnt = 0;
				for (int i = 0; i < dayTime.length; i++) {
					time = dayTime[i].split("~");
					Map<String, Object> params = new HashMap<>();
					params.put("stNo", vo.getStNo());
					params.put("day", day[i]);
					params.put("startTime", time[0]);
					params.put("endTime", time[1]);

					List<Map<String, Object>> tf = SqlSession.selectList(
							"co.fourth.tuna.domain.lectureBasket.mapper.LectureBasketMapper.FindRoom", params);
					if (tf.toString().equals("[true]")) {
						ra.addFlashAttribute("error", "강의실 시간 중복입니다.");
						return "redirect:/stud/courseBasket";
					} else {
						cnt++;
					}

					if (cnt == 2) {
						LectureBasketDao.baskInsert(vo);
					}
				}

			} else {
				String[] time = null;
				String[] dayTime = sbjarr[3].split(" ");
				for (int i = 0; i < dayTime.length; i++) {
					time = dayTime[i].split("~");
					Map<String, Object> params = new HashMap<>();
					params.put("stNo", vo.getStNo());
					params.put("day", sbjarr[2]);
					params.put("startTime", time[0]);
					params.put("endTime", time[1]);
					List<Map<String, Object>> tf = SqlSession
							.selectList("co.fourth.tuna.domain.lectureBasket.mapper.LectureBasketMapper.FindRoom", params);
					if (tf.toString().equals("[true]")) {
						ra.addFlashAttribute("error", "강의실 시간 중복입니다.");
						return "redirect:/stud/courseBasket";
					} else {
						LectureBasketDao.baskInsert(vo);

					}
				}
			}
			if(checkCount == 1) {
				return "redirect:/stud/courseBasket";
			}
		}

		return "redirect:/stud/courseBasket";

	}

	@RequestMapping("/stud/basketDelete")
	public String basketDelete(Model model, LectureBasketVO vo) {

		LectureBasketDao.baskDelete(vo);
		LectureBasketDao.courDelete(vo);
		return "redirect:/stud/courseBasket";
	}

	@RequestMapping("/stud/courseBasketLectureList")
	public String courseBasketLectureList(Model model, LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo.getStNo());
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasketLectureList";
	}

	@RequestMapping("/stud/courseBasketSchedule")
	public String courseBasketSchedule(Model model, LectureBasketVO vo, Authentication authentication) {
		vo.setStNo(authentication.getName());
		List<Map<String, Object>> baskLists = SqlSession
				.selectList("co.fourth.tuna.domain.lectureApply.mapper.LectureApplyMapper.CourseBasket", vo.getStNo());
		model.addAttribute("baskList", baskLists);

		return "course/basket/courseBasketSchedule";

	}
	
	
	
}
