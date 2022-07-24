package co.fourth.tuna.domain.user.mapper;

import co.fourth.tuna.domain.user.vo.AdminVO;

public interface AdminMapper {
	public AdminVO findById(AdminVO vo);
	public void adminEamilPwdUpdate(AdminVO vo);
	public void adminInfoUpdate(AdminVO vo);
	public void adminpwdUpdate(AdminVO vo);
	public String adminPwdFind(AdminVO vo);
}
