package co.fourth.tuna.domain.user.mapper;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.user.vo.AdminVO;

public interface AdminMapper {
	public AdminVO findById(AdminVO vo);
	public void adminEamilPwdUpdate(AdminVO vo);
	public void adminInfoUpdate(AdminVO vo);
	public void adminpwdUpdate(AdminVO vo);
	public String adminPwdFind(AdminVO vo);
	public boolean findEmail(AdminVO vo);
	public int AdminUserCount(Map<String, Object> params);
	public List<Map<String,Object>> adminUserCheck(Map<String,Object> params);
}
