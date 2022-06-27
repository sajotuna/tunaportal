package co.fourth.tuna.usertest.mapper;

import java.util.List;

import co.fourth.tuna.usertest.vo.userTestVO;

public interface userTestMapper {
	public List<userTestVO> findAll();
	public userTestVO findById(userTestVO vo);
}
