package co.fourth.tuna.web.eclass.student.service;

import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

public interface EclassStudentHomeService {
	//내가 수강중인 과목 홈 출력
		public EclassStudentHomeVO subList(EclassStudentHomeVO vo);
}
