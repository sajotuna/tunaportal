package co.fourth.tuna.legacy.usertest.mapper;

import java.util.List;

import co.fourth.tuna.legacy.usertest.vo.UserTestVO;

public interface UserTestMapper {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
