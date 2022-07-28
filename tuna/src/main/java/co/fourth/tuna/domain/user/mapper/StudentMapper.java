package co.fourth.tuna.domain.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.fourth.tuna.domain.user.vo.StudentExVO;
import co.fourth.tuna.domain.user.vo.StudentVO;
import co.fourth.tuna.domain.user.vo.StudentWithAttendanceVO;
import co.fourth.tuna.domain.user.vo.StudentWithSubmitTaskVO;

public interface StudentMapper {
	public StudentVO findById(StudentVO vo);

	public void studUpdate(StudentVO vo);
	public void AdminStudUpdate(StudentVO vo);
	public StudentVO findOneById(int no);
	public void studPwdUpdate(StudentVO vo);
	public StudentVO findByUserId(StudentVO vo);
	public String findStudPwd(StudentVO vo);
	public boolean findEmail(StudentVO vo);
	public void studEamilPwdUpdate(StudentVO vo);
	//TODO 사용자 가져올 때 비밀번호 제외
	public List<StudentVO> findStudentsBySubjectId(int sbjno);
	public List<StudentExVO> findListBySubjectId(int sbjno);
	public List<StudentWithSubmitTaskVO> findListWithSubmitTaskByTaskId(int taskno);
	public List<StudentWithAttendanceVO> findStudentWithAttendanceListBySubjectId(int sbjno);

	public void freshmanPwdUpdate(StudentVO vo);
	
	public List<StudentWithSubmitTaskVO> findOneStudentBysubjectNo(@Param("sbjNo")int sbjNo, 
																	@Param("stNo")int stNo);
}
