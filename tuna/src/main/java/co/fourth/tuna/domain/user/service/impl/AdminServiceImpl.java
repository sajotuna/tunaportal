package co.fourth.tuna.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.user.mapper.AdminMapper;
import co.fourth.tuna.domain.user.service.AdminService;
import co.fourth.tuna.domain.user.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired AdminMapper mapper;
	
	@Override
	public AdminVO findById(AdminVO vo) {
		return mapper.findById(vo);
	}

	@Override
	public void adminEamilPwdUpdate(AdminVO vo) {
		mapper.adminEamilPwdUpdate(vo);
	}

	@Override
	public void adminInfoUpdate(AdminVO vo) {
		mapper.adminInfoUpdate(vo);
		
	}

	@Override
	public void adminpwdUpdate(AdminVO vo) {
		mapper.adminpwdUpdate(vo);
	}

	@Override
	public String adminPwdFind(AdminVO vo) {
		return mapper.adminPwdFind(vo);
	}

	@Override
	public boolean findEmail(AdminVO vo) {
		return mapper.findEmail(vo);
	}

	@Override
	public int AdminUserCount() {
		return mapper.AdminUserCount();
	}

}
