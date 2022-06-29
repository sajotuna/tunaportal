package co.fourth.tuna.usertest.service;

import java.util.List;


import co.fourth.tuna.usertest.vo.UserTestVO;

public interface UserTestService {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
