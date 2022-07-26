package co.fourth.tuna.domain.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.fourth.tuna.domain.common.service.YearService;
import co.fourth.tuna.domain.lectureApply.service.LectureApplyService;
import co.fourth.tuna.domain.lectureApply.vo.LectureApplyVO;
import co.fourth.tuna.domain.lectureBasket.service.LectureBasketService;
import co.fourth.tuna.domain.lectureBasket.vo.LectureBasketVO;
import co.fourth.tuna.domain.scholar.service.ScholarService;
import co.fourth.tuna.domain.scholar.vo.ScholarApplyVO;

@Component
public class TunaScheduler {

	@Autowired
	private ScholarService ScholarDao;
	@Autowired
	private YearService yearDao; 
	@Autowired
	private LectureApplyService LectureApplyDao;
	@Autowired
	private LectureBasketService LectureBasketDao;
	// 장학심사대기
	@Scheduled(cron = "0 0 0 24 1 *")
	public void scholarCheckSpring() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarCheckUpdate(vo);
	}

	@Scheduled(cron = "0 0 0 25 7 *")
	public void scholarCheckfall() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarCheckUpdate(vo);
	}

	// 장학심사완료
	@Scheduled(cron = "0 0 0 30 1 *")
	public void scholarSuccessSpring() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarSuccessUpdate(vo);
	}

	@Scheduled(cron = "0 0 0 30 7 *")
	public void scholarSuccessfall() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarSuccessUpdate(vo);
	}
	
	// 장학생 금액 지급
	@Scheduled(cron = "0 0 0 1 2 *")
	public void scholarApplySpring() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarStudentGiveMoney(vo);
	}

	@Scheduled(cron = "0 0 0 1 8 *")
	public void scholarApplyfall() {
		ScholarApplyVO vo = new ScholarApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		ScholarDao.scholarStudentGiveMoney(vo);
	}

	// 수강신청
	@Scheduled(cron = "0 0 0 14 2 *")
	public void courseApplySpring() {
		LectureApplyVO vo = new LectureApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		LectureApplyDao.LectureApplySchedule(vo);
	}

	@Scheduled(cron = "0 0 0 15 8 *")
	public void courseApplyfall() {
		LectureApplyVO vo = new LectureApplyVO();
		vo.setSeasonCode(yearDao.yearFind());
		LectureApplyDao.LectureApplySchedule(vo);
	}

	// 수강꾸러미
	@Scheduled(cron = "0 0 0 6 2 *")
	public void basketCheckSpring() {
		LectureBasketVO vo = new LectureBasketVO();
		vo.setSeasonCode(yearDao.yearFind());
		LectureBasketDao.baskInsert(vo);
	}

	@Scheduled(cron = "0 0 0 8 8 *")
	public void basketCheckfall() {
		LectureBasketVO vo = new LectureBasketVO();
		vo.setSeasonCode(yearDao.yearFind());
		LectureBasketDao.baskInsert(vo);
	}

}
