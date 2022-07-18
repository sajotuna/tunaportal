package co.fourth.tuna.web.eclass.student.mapper;

import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

public interface EclassStudentHomeMapper {
	
	//내가 수강중인 과목 홈 출력
	public EclassStudentHomeVO subList(EclassStudentHomeVO vo);
	
	//내가 수강중인 과목 과제 2개 출력
	public String twoTask(EclassStudentHomeVO vo); 
}
