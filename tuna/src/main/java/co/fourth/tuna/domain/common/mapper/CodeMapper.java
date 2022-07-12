package co.fourth.tuna.domain.common.mapper;

import java.util.ArrayList;
import java.util.List;

import co.fourth.tuna.domain.common.vo.code.CodeMasterVO;
import co.fourth.tuna.domain.common.vo.code.CodeVO;

public interface CodeMapper {
	public ArrayList<CodeVO> getCodeList();
	public ArrayList<CodeMasterVO> getCodeMasterList();
}
