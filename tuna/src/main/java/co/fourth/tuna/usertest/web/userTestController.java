package co.fourth.tuna.usertest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.usertest.service.userTestService;
import co.fourth.tuna.usertest.vo.userTestVO;

@Controller
public class userTestController {
	
	@Autowired
	userTestService userDao;
	
	@RequestMapping("/userInfo.do")
	public String userTest(Model model) {
		List<userTestVO> list = userDao.findAll();
		model.addAttribute("list", list);
		return "test/test";
	}
}
