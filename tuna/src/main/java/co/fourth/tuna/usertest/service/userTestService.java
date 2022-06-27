package co.fourth.tuna.usertest.service;

import java.util.List;


import co.fourth.tuna.usertest.vo.userTestVO;

public interface userTestService {
	public List<userTestVO> findAll();
	public userTestVO findById(userTestVO vo);
}
