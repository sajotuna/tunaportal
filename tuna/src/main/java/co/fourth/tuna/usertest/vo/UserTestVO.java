package co.fourth.tuna.usertest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

public class UserTestVO implements UserDetails{
	private String studentId;
	private String studentPwd;
	private String studentEmail;
	private String userRole;
	
	
	
	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public String getStudentPwd() {
		return studentPwd;
	}



	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}



	public String getStudentEmail() {
		return studentEmail;
	}



	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	@Override
	public String toString() {
		return "userTestVO [studentId=" + studentId + ", studentPwd=" + studentPwd + ", studentEmail=" + studentEmail
				+ ", userRole=" + userRole + "]";
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한 지정
		List<GrantedAuthority> auth = new ArrayList<>(); 
		auth.add(new SimpleGrantedAuthority(this.userRole.toUpperCase()));
		return null;
	}
	@Override
	public String getUsername() {
		return studentId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return studentPwd;
	}

	
	
	
}
