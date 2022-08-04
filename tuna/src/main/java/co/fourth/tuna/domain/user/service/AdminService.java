package co.fourth.tuna.domain.user.service;

import java.util.Map;

import co.fourth.tuna.domain.user.vo.AdminVO;

public interface AdminService {
	
	public AdminVO findById(AdminVO vo);
	public void adminEamilPwdUpdate(AdminVO vo);
	public void adminInfoUpdate(AdminVO vo);
	public void adminpwdUpdate(AdminVO vo);
	public String adminPwdFind(AdminVO vo);
	public boolean findEmail(AdminVO vo);
	public int AdminUserCount(Map<String, Object> params);
}
