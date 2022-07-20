package co.fourth.tuna.domain.common.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.CodeMapper;
import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.common.vo.code.CodeVO;

@Service
public class CodeService {
	public static HashMap<String, ArrayList<CodeVO>> CODE_ARR_MAP;
	public static ArrayList<CodeMasterVO> CODE_MASTER_LIST;
	
	public static ArrayList<CodeVO> CODE_LIST;
	public static HashMap<String, CodeVO> CODE_MAP;
	
	@Autowired
	private CodeMapper map;
	
	@PostConstruct
	private void initCodeList() {
		CODE_ARR_MAP = new HashMap<>();
		CODE_MASTER_LIST = getCodeMasterList();
		
		CODE_MAP = new HashMap<>();
		CODE_LIST = getCodeList();

		if (CODE_MASTER_LIST != null && CODE_MASTER_LIST.size() > 0) {
			for (CodeMasterVO cm : CODE_MASTER_LIST) {
				CODE_ARR_MAP.put(cm.getNo(), cm.getChildren());
			}
		}
		
		if(CODE_LIST != null && CODE_LIST.size() > 0) {
			for(CodeVO cd : CODE_LIST) {
				CODE_MAP.put(cd.getNo(), cd);
			}
		}
	}
	
	public ArrayList<CodeMasterVO> getCodeMasterList(){
		return map.getCodeMasterList();
	}
	
	public ArrayList<CodeVO> getCodeList() {
		return map.getCodeList();
	}
	
	public CodeMasterVO findById(String no) {
		return map.findCodeMaster(no);
	}
	
	public String getName(String code) {
		String codeResult = "";
		
		if(CODE_MAP != null) {
			codeResult = CODE_MAP.get(code).getCodeName(); 
		}
		
		return codeResult;
	}

}
