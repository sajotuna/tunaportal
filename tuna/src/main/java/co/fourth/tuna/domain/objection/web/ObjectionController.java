package co.fourth.tuna.domain.objection.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.fourth.tuna.domain.banner.web.BannerController;
import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.objection.service.ObjectionService;
import co.fourth.tuna.domain.objection.vo.ObjectionVO;

@RestController
public class ObjectionController {
	
	private static Logger logger = LoggerFactory.getLogger(BannerController.class); 
	
	@Autowired ObjectionService objectionDao;
	@Autowired YearService yearDao;
	
	@GetMapping("/portal/student/objectionList")
	public List<ObjectionVO> objectionListSelect(int stNo) {
		
		ObjectionVO vo = new ObjectionVO();
		vo.setStNo(stNo);
		vo.setSeasonCode(yearDao.yearFind());
		
		return objectionDao.objectionListOfStud(vo);
	}
	
	@PutMapping("/portal/student/objection")
	public int objectionContentInsert(@RequestBody ObjectionVO vo) {
		return objectionDao.objectionInsert(vo);
	}
	
	@GetMapping("/eclass/professor/seasonObjectionList")
	public List<Map<String, Object>> seasonObjectionList(int pfNo, String seasonCode) {
		return objectionDao.objectionListOfProf(pfNo, seasonCode);
	}
	
	@GetMapping("/eclass/professor/objection")
	public Map<String, Object> objectionSelect(int objNo) {
		return objectionDao.objectionSelect(objNo);
	}
	
	@PutMapping("/eclass/professor/objection")
	public int objectionUpdate(@RequestBody ObjectionVO vo) {
		return objectionDao.objectionUpdate(vo);
	}
	
}	
