package co.fourth.tuna.domain.user.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@Autowired
	private BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

	@RequestMapping("/admin/admin/userSearch")
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
	
	@PostMapping("/prof/students")
	@ResponseBody
	public List<StudentExVO> getStudentsBySubjectId(
			@RequestBody Map<String, Integer> reqData) {
		return StudentDao.findListBySubjectId(reqData.get("sbjno"));
	}
	
	@RequestMapping("/admin/adminUpdate")
	public String adminUpdate(Model model, AdminVO vo,Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		model.addAttribute("vo", AdminDao.findById(vo));
		return "manage/user/adminUpdate";
	}
	
	@RequestMapping("/admin/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/adminPwdUpdate";
	}
	
	@RequestMapping("/admin/adminInfoUpdate")
	public String adminInfoUpdate(AdminVO vo,Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		AdminDao.adminInfoUpdate(vo);
		return "redirect:/admin/adminUpdate";
	}
	
	@RequestMapping("/admin/userpwdUpdate")
	public String userpwdUpdate(RedirectAttributes ra,Model model, String beforepassword, AdminVO vo){
		String oldpwd = AdminDao.adminPwdFind(vo);
		String message = "";
		if(enc.matches(beforepassword,oldpwd)) {
			vo.setPwd(enc.encode(vo.getPwd()));
			AdminDao.adminpwdUpdate(vo);    
			System.out.println("비밀번호 변경");
			message = "비밀번호가 변경 되었습니다.";
		}else {
			System.out.println("비밀번호 변경실패");
			message = "비밀번호가 틀립니다.";
		}
		ra.addAttribute("message", message);
		return "redirect:/admin/pwdUpdate";
	}
	
	
	
	
	
	
	
	
	
}
