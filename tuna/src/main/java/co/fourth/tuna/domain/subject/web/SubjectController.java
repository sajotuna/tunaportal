package co.fourth.tuna.domain.subject.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.fourth.tuna.domain.subject.vo.SubjectVO;


@Controller
public class SubjectController {
	
	@Autowired SqlSession SqlSession;
	
	@ResponseBody
	@RequestMapping("/stud/courseCheck")
	public List<SubjectVO> courseCheck(){
		return SqlSession.selectList("co.fourth.tuna.domain.subject.mapper.SubjectMapper.SubjectCheck");
	}
	
}
