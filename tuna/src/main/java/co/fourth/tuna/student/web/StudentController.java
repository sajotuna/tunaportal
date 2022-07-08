package co.fourth.tuna.student.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/userUpdate")
	public String userUpdate() {
		return "manage/user/userUpdate";
	}
	@RequestMapping("/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/pwdUpdate";
	}
	@RequestMapping("/admin/adminUserSearch")
	public String adminUserSearch() {
		return "manage/admin/adminUserSearch";
	}
	@RequestMapping("/admin/adminUserInfo")
	public String adminUserInfo() {
		return "manage/admin/adminUserInfo";
	}
	
}
