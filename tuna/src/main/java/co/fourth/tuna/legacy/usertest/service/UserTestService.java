package co.fourth.tuna.legacy.usertest.service;

import java.util.List;

import co.fourth.tuna.legacy.usertest.vo.UserTestVO;

public interface UserTestService {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
