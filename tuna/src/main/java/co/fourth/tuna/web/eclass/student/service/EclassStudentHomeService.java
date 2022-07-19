package co.fourth.tuna.web.eclass.student.service;

import co.fourth.tuna.web.eclass.student.vo.EclassStudentHomeVO;

public interface EclassStudentHomeService {
	//내가 수강중인 과목 홈 출력
		public EclassStudentHomeVO subList(EclassStudentHomeVO vo);
		
		//내가 수강중인 과목 과제 2개 출력
		public String twoTask(EclassStudentHomeVO vo); 
		
		//수강중인 단일과목 과제 2개
		public String singleTwoTask(EclassStudentHomeVO vo);
		//수강중인 단일과목 공지 2개
		public String singleTwoNotice(EclassStudentHomeVO vo);
		//수강중인 단일과목 질문 2개
		public String singleTwoQna(EclassStudentHomeVO vo);
		//수강중인 단일과목 자료 2개
		public String singleTwoFile(EclassStudentHomeVO vo);
}
