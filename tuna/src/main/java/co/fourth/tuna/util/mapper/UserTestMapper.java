package co.fourth.tuna.util.mapper;

import java.util.List;

import co.fourth.tuna.util.vo.UserTestVO;

public interface UserTestMapper {
	public List<UserTestVO> findAll();
	public UserTestVO findById(UserTestVO vo);
}
