package co.fourth.tuna.usertest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.usertest.service.UserTestService;
import co.fourth.tuna.usertest.vo.UserTestVO;

@Controller
public class UserTestController {
	
	@Autowired
	UserTestService userDao;
	
	@RequestMapping("/userInfo.do")
	public String userTest(Model model) {
		List<UserTestVO> list = userDao.findAll();
		model.addAttribute("list", list);
		return "test/test";
	}
}
