package co.fourth.tuna.domain.lectureFile.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LectureFileController {
	
	@PostMapping("/prof/insertSubjectFile")
	public ResponseEntity<String> insertTask() {
		ResponseEntity<String> res = null;
		
		return res;
	}
	
	
}
