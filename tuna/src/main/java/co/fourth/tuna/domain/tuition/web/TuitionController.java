package co.fourth.tuna.domain.tuition.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.fourth.tuna.domain.portalSchedule.vo.PortalScheduleVO;
import co.fourth.tuna.domain.tuition.service.TuitionService;
import co.fourth.tuna.domain.tuition.vo.tuitionGiveVO;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class TuitionController {

	@Autowired private TuitionService tuitionDao;
	
	
	@Autowired
	private SqlSession SqlSession;
	
	@Autowired
	private StudentService studentDao;
	
	@Autowired
	private PortalScheduleService portalDao;
	
	@ResponseBody
	@RequestMapping("/stud/TuitionScheduleFind")
	public PortalScheduleVO TuitionScheduleFind(PortalScheduleVO vo , @RequestBody Map<String, String> map) {
		
		vo.setSeasonCode(map.get("seasonCode"));
		
		return portalDao.findTuitionSchedule(vo);
		
	}
	
	
	@ResponseBody
	@RequestMapping("/stud/tuition")
	public List<tuitionGiveVO> adminScholarshipSearch(tuitionGiveVO vo , @RequestBody Map<String, Integer> map) {
		
		return SqlSession.selectList("co.fourth.tuna.domain.tuition.mapper.TuitionMapper.tuitionCheck",map);
	}
	
	
	
	@RequestMapping("/stud/tuition/Check")
	public String adminScholarshipApplicationSearch(Model model,StudentVO vo,Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		model.addAttribute("vo", studentDao.findById(vo));
		
		return "scholarship/user/tuitionCheck";
	}
	
	
}
