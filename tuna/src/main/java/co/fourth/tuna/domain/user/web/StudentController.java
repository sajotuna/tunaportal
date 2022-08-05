package co.fourth.tuna.domain.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.fourth.tuna.domain.task.vo.EclassStudentDetailPageVO;
import co.fourth.tuna.domain.user.service.StudentService;
import co.fourth.tuna.domain.user.vo.StudentWithSubjectsVO;
import co.fourth.tuna.domain.user.vo.StudentVO;

@Controller
public class StudentController {
	
	@Autowired 
	private StudentService StudentDao;
	 @Autowired
	    private AuthenticationManager authenticationManager; 
	@Autowired
	private BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

	@RequestMapping("/stud/userUpdate")
	public String userUpdate(Model model, StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo = StudentDao.findById(vo);
		model.addAttribute("vo", vo);
		return "manage/user/userUpdate";
	}
	
	@RequestMapping("/stud/userInfoUpdate")
	public String userInfoUpdate(RedirectAttributes ra,StudentVO vo, Authentication authentication) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		StudentDao.studUpdate(vo);
		ra.addFlashAttribute("success", "회원정보 수정이 완료되었습니다.");
		return "redirect:/stud/userUpdate";
	}
	
	@RequestMapping("/stud/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/pwdUpdate";
	}
	
	@RequestMapping("/admin/AdminUserUpdate")
	public String AdminUserUpdate(StudentVO vo,RedirectAttributes ra) {
		StudentDao.AdminStudUpdate(vo);
		ra.addAttribute("no", vo.getNo());
		ra.addFlashAttribute("success", "회원정보 수정이 완료되었습니다.");
		return "redirect:/admin/admin/userInfo";
	}
	
	@RequestMapping("/stud/userpwdUpdate")
	public String userpwdUpdate(RedirectAttributes ra,Model model, String beforepassword, StudentVO vo){
		String oldpwd = StudentDao.findStudPwd(vo);
		String message = "";
		if(enc.matches(beforepassword,oldpwd)) {
			vo.setPwd(enc.encode(vo.getPwd()));
			StudentDao.studPwdUpdate(vo);
			message = "비밀번호가 변경 되었습니다.";
		}else {
			message = "비밀번호가 틀렸습니다.";
			ra.addFlashAttribute("error", message);
			return "redirect:/stud/pwdUpdate";
		}
		ra.addFlashAttribute("success", message);
		return "redirect:/stud/pwdUpdate";
	}
	
	@RequestMapping("/stud/freshmanUpdate")
	public String freshmanUpdate(Authentication authentication, RedirectAttributes ra, StudentVO vo) {
		vo.setNo(Integer.parseInt(authentication.getName()));
		vo.setPwd(enc.encode(vo.getPwd()));
		StudentDao.freshmanPwdUpdate(vo);
		String message = "비밀번호 및 이메일이 변경 완료되었습니다.";
		ra.addFlashAttribute("success", message);
		
		vo = StudentDao.findById(vo);
		
		authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(vo.getNo(), vo.getPwd()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/home";
		
	}
	
	@PostMapping("/staff/student")
	public ResponseEntity<EclassStudentDetailPageVO> getStudentDetail(
			Authentication auth, 
			@RequestBody StudentVO student) {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<EclassStudentDetailPageVO> res = null;
		EclassStudentDetailPageVO result = new EclassStudentDetailPageVO();
		
		try {
			result.setStudent(StudentDao.getOneByStudentId(student.getNo(), Integer.parseInt(auth.getName())));
			res = new ResponseEntity<EclassStudentDetailPageVO>(
					result,
					resHeaders,
					HttpStatus.OK);
		} catch ( Throwable e ) {
			result.setMsg(e.getMessage());
			res = new ResponseEntity<EclassStudentDetailPageVO>(
					result,
					resHeaders,
					HttpStatus.BAD_REQUEST);
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
}
