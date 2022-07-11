package co.fourth.tuna.util.service;

import java.util.List;

import co.fourth.tuna.util.vo.UserTestVO;

public interface UserTestService {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
