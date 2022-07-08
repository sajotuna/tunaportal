package co.fourth.tuna.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.admin.mapper.AdminMapper;
import co.fourth.tuna.admin.service.AdminService;
import co.fourth.tuna.admin.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired AdminMapper mapper;
	
	@Override
	public AdminVO findById(AdminVO vo) {
		// TODO Auto-generated method stub
		return mapper.findById(vo);
	}

}
