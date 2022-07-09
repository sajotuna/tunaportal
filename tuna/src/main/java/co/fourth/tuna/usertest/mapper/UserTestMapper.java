package co.fourth.tuna.usertest.mapper;

import java.util.List;

import co.fourth.tuna.usertest.vo.UserTestVO;

public interface UserTestMapper {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
