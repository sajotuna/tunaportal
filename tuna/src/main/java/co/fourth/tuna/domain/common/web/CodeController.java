package co.fourth.tuna.domain.common.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.fourth.tuna.domain.common.service.CodeService;
import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.common.vo.code.CodeVO;

@Controller
public class CodeController {
	public static HashMap<String, ArrayList<CodeVO>> CODE_ARR_MAP;
	public static ArrayList<CodeMasterVO> CODE_MASTER_LIST;
	
	public static String codeResult;
	
	public static ArrayList<CodeVO> CODE_LIST;
	public static HashMap<String, CodeVO> CODE_MAP;

	@Autowired
	private CodeService codeService;

	public HashMap<String, CodeVO> setCodeList() {
		
		CODE_ARR_MAP = new HashMap<>();
		CODE_MASTER_LIST = codeService.getCodeMasterList();
		
		CODE_MAP = new HashMap<>();
		CODE_LIST = codeService.getCodeList();

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
		return CODE_MAP;
	}
	
	public String getName(String code) {
		codeResult = "";
		
//		if (CODE_ARR_MAP != null) {
//			ArrayList<CodeVO> codeList = CODE_ARR_MAP.get(grpCd);
//
//			if (codeList != null && codeList.size() > 0) {
//				for (CodeVO mCode : codeList) {
//					System.out.println(">>>");
//					System.out.println(mCode.getCodeName());
//					if (mCode.getCodeName() != null && mCode.getNo().equals(code)) {
//						codeResult = mCode.getCodeName();
//					}
//				}
//			}
//		}
		if(CODE_MAP != null) {
			codeResult = codeService.getName(code); 
		}
		
		return codeResult;
	}

//	public ArrayList<CodeVO> getChild(String grpCode, String codeName) {
//		codeResult = "";
//
//		if (CODE_ARR_MAP != null) {
//			ArrayList<CodeVO> codeList = CODE_ARR_MAP.get(grpCode);
//
//			if (codeList != null && codeList.size() > 0) {
//				for (CodeVO mCode : codeList) {
//					if (mCode.getCodeName() != null && mCode.getCodeName().equals(codeName)) {
//						codeResult = mCode.getNo();
//					}
//				}
//			}
//		}
//
//		return codeResult;
//	}
}
