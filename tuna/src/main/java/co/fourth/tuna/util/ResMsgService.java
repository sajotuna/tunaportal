package co.fourth.tuna.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

@Service
public class ResMsgService {
	@Autowired
	MessageSourceAccessor msgDao;
	
	// msg 파라미터가 없는 경우
	public ResMsgVO build(String titleCode, String msgCode, String type) {
		ResMsgVO resMsg = new ResMsgVO();
		resMsg.setTitle(msgDao.getMessage(titleCode));
		resMsg.setMsg(msgDao.getMessage(msgCode));
		resMsg.setType(type);
		
		return resMsg;
	}
	
	// msg 에 파라미터가 있는 경우
	public ResMsgVO build(String titleCode, String[] msgCode, String type) {
		String[] msgParam = {msgCode[1]};
		ResMsgVO resMsg = new ResMsgVO();
		resMsg.setTitle(msgDao.getMessage(titleCode));
		resMsg.setMsg(msgDao.getMessage(msgCode[0], msgParam));
		resMsg.setType(type);
		
		return resMsg;
	}
}
