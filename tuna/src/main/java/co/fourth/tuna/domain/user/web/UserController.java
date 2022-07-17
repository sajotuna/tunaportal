package co.fourth.tuna.domain.user.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.fourth.tuna.domain.user.service.AdminService;
import co.fourth.tuna.domain.user.vo.AdminVO;


@Controller
public class UserController {

	@Autowired 
	private AdminService AdminDao;
	@Autowired
	private SqlSession SqlSession;
	@RequestMapping("/admin")
	public String Admin(Model model, AdminVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = AdminDao.findById(vo);
		model.addAttribute("vo", vo);
		return "home";
	}

	@RequestMapping("/admin/adminUserSearch")
	public String adminUserSearch(Model model, @RequestParam Map<String, Object> params, @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {
		
		params.put("pageNum", pageNum);
		params.put("size", 10);
		
		List<Map<String,Object>> lists = SqlSession.selectList("co.fourth.tuna.domain.user.mapper.AdminMapper.adminUserCheck", params);
		
		model.addAttribute("list", lists);
		
		return "manage/admin/adminUserSearch";
	}
	@RequestMapping("/admin/adminUserInfo")
	public String adminUserInfo() {
		return "manage/admin/adminUserInfo";
	}
	
}
