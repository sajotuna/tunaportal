package co.fourth.tuna.domain.user.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.user.service.AdminService;
import co.fourth.tuna.domain.user.service.ProfessorService;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.AdminVO;
import co.fourth.tuna.domain.user.vo.ProfessorVO;
import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;


@Controller
public class UserController {

	@Autowired 
	private AdminService AdminDao;
	@Autowired 
	private StudentService StudentDao;
	@Autowired
	private SqlSession SqlSession;
	@Autowired 
	private ProfessorService professorDao;
	
	@RequestMapping("/admin/adminUserSearch")
	public String adminUserSearch(Model model, @RequestParam Map<String, Object> params, @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {
		
		params.put("pageNum", pageNum);
		params.put("size", 10);
		
		if(params.get("year") != null && !params.get("year").equals("")) {
			String Date = (String)params.get("year");
			System.out.println(Date.substring(0, Date.indexOf(" ")) +"~"+ (Date.substring(Date.lastIndexOf(" "),Date.length())).trim());
			
			params.put("startDate", Date.substring(0, Date.indexOf(" ")));
			params.put("endDate", (Date.substring(Date.lastIndexOf(" "),Date.length())).trim());
		}
		
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.user.mapper.AdminMapper.adminUserCheck", params);
		
		model.addAttribute("list", lists);
		model.addAttribute("params", params);
		
		return "manage/admin/adminUserSearch";
	}
	
	
	
	@RequestMapping("/admin/adminUserInfo")
	public String adminUserInfo(Model model,String no) {
		
		if(no.length() == 5) {
			ProfessorVO provo = new ProfessorVO();
			provo.setNo(Integer.parseInt(no));
			provo = professorDao.findById(provo);
			model.addAttribute("vo", provo);
			return "manage/admin/profInfo";
		}else {
			StudentVO vo = new StudentVO();
			vo.setNo(Integer.parseInt(no));
			vo = StudentDao.findById(vo);
			model.addAttribute("vo", vo);
			return "manage/admin/studentInfo";
		}
		
		
	}
	
	@PostMapping("/students")
	@ResponseBody
	public List<StudentExVO> getStudentsBySubjectId(
			@RequestBody Map<String, Integer> reqData) {
		return StudentDao.findListBySubjectId(reqData.get("sbjno"));
	}
	
}
