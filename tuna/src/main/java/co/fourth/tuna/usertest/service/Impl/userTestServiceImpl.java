package co.fourth.tuna.usertest.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.fourth.tuna.usertest.mapper.userTestMapper;
import co.fourth.tuna.usertest.service.userTestService;
import co.fourth.tuna.usertest.vo.userTestVO;

@Service
public class userTestServiceImpl implements userTestService, UserDetailsService{
	
	Logger logger = LoggerFactory.getLogger(userTestServiceImpl.class);
	
	
	@Autowired
	userTestMapper mapper;

	@Override
	public List<userTestVO> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	
	@Override
	public userTestVO findById(userTestVO vo) {
		// TODO Auto-generated method stub
		return mapper.findById(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userTestVO vo = new userTestVO();
		vo.setStudentId(username);
		vo = mapper.findById(vo);
		if(vo == null)
			throw new UsernameNotFoundException("no user");
		
		logger.info(vo.toString());
		
		return vo;
	}

	
	
	
}
