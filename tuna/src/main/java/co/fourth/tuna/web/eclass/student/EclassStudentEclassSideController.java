package co.fourth.tuna.web.eclass.student;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.fourth.tuna.web.eclass.EclassController;
import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

@Component
public class EclassStudentEclassSideController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);
	
//	//수강목록 사이드바 유지할 목적
//	@Autowired private SqlSession sql;
//	@RequestMapping("/aside")
//	public String home(Model model, EclassStudentHomeVO vo) {
//		vo.setNo(13168019);
//		vo.setSeasonCode(106);
//		List<Map<String, Object>> side = sql.selectList("co.fourth.tuna.web.eclass.student.mapper.EclassStudentHomeMapper.subList", vo);
//		
//		System.out.println(2345);
//		model.addAttribute("side", side);
//		return "layouts/aside/eclassSidebar2";
//	}
//	
}
