package co.fourth.tuna.domain.common.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.CodeMapper;
import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.common.vo.code.CodeVO;

@Service
public class CodeService {
	
	@Autowired
	private CodeMapper map;
	
	public ArrayList<CodeMasterVO> getCodeMasterList(){
		return map.getCodeMasterList();
	}
	
	public ArrayList<CodeVO> getCodeList() {
		return map.getCodeList();
	}
	
	public CodeMasterVO findById(String no) {
		return map.findCodeMaster(no);
	}

}
