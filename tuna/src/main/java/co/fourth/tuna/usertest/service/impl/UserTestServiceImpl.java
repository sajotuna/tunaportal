package co.fourth.tuna.usertest.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.fourth.tuna.usertest.mapper.UserTestMapper;
import co.fourth.tuna.usertest.service.UserTestService;
import co.fourth.tuna.usertest.vo.UserTestVO;

@Service
public class UserTestServiceImpl implements UserTestService, UserDetailsService{
	
	Logger logger = LoggerFactory.getLogger(UserTestServiceImpl.class);
	
	
	@Autowired
	UserTestMapper mapper;

	@Override
	public List<UserTestVO> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	
	@Override
	public UserTestVO findById(UserTestVO vo) {
		// TODO Auto-generated method stub
		return mapper.findById(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTestVO vo = new UserTestVO();
		vo.setStudentId(username);
		vo = mapper.findById(vo);
		if(vo == null)
			throw new UsernameNotFoundException("no user");
		
		logger.info(vo.toString());
		
		return vo;
	}

	
	
	
}
