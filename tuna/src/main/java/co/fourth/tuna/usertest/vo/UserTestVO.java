package co.fourth.tuna.usertest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserTestVO implements UserDetails {
	private String studentId;
	private String studentPwd;
	private String studentEmail;
	private String userRole;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>(); 
		auth.add(new SimpleGrantedAuthority("ROLE_" + this.userRole.toUpperCase()));
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
	public String toString() {
		return "userTestVO [studentId=" + studentId + ", studentPwd=" + studentPwd + ", studentEmail=" + studentEmail
				+ ", userRole=" + userRole + "]";
	}
	@Override
	public String getPassword() {
		return null;
	}
}
