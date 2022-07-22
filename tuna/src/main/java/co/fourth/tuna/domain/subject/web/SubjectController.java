package co.fourth.tuna.domain.subject.web;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.fourth.tuna.domain.subject.service.SubjectService;
import co.fourth.tuna.domain.subject.vo.SubjectVO;


@Controller
public class SubjectController {
	
	@Autowired SqlSession SqlSession;
	@Autowired SubjectService subjectDao;
	
	@ResponseBody
	@RequestMapping("/courseCheck")
	public List<SubjectVO> courseCheck(){
		return SqlSession.selectList("co.fourth.tuna.domain.subject.mapper.SubjectMapper.SubjectCheck");
	}
	
	@ResponseBody
	@GetMapping("/stud/searchSubjectList")
	public List<SubjectVO> searchSubjectList(String seasonCode, String searchKey, String key) {
		return subjectDao.searchSubjectList(seasonCode, searchKey, key);
	}
	
	@ResponseBody
	@PostMapping("/prof/updateSubject")
	public String updateSubject(
			@RequestBody String reqData) {
		HashMap<String, Object> jsonMap = null;
		try {
			jsonMap = new ObjectMapper().readValue(reqData, HashMap.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonMap.get("plans").getClass());
		return null;
	}
	
}
