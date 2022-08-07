package co.fourth.tuna.domain.scholar.service;

import java.util.List;
import java.util.Map;

import co.fourth.tuna.domain.scholar.vo.ScholarApplyVO;
import co.fourth.tuna.domain.scholar.vo.ScholarVO;

public interface ScholarService {
	public void ScholarApply(ScholarApplyVO vo);
	public List<ScholarVO> FindScholar(ScholarVO vo);
	public void FileUpLoad(ScholarApplyVO vo);
	public void ScholarDelete(ScholarApplyVO vo);
	public void scholarUpdate(ScholarApplyVO vo);
	public List<ScholarApplyVO> scholarApplyCheck(ScholarApplyVO vo);
	public void scholarCheckUpdate (ScholarApplyVO vo);
	public void scholarSuccessUpdate (ScholarApplyVO vo);
	public void scholarStudentGiveMoney (ScholarApplyVO vo);
	public int scholarApplyCount(Map<String, Object> params);
	public List<Map<String, Object>> ScholarCheck(ScholarApplyVO vo);
	public List<Map<String, Object>> adminScholarCheck (Map<String, Object> params);
}
