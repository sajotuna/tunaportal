package co.fourth.tuna.web.eclass.professor.vo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.fourth.tuna.domain.user.vo.StudentWithAttendanceVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectAttendanceRestVO {
	List<StudentWithAttendanceVO> students;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone="Asia/Seoul")
	LocalDate date;
}
