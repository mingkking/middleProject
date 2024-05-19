package service.reservation;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.product.ProductDAO;
import dao.reservation.ReservationDAO;
import vo.product.ProductVO;
import vo.reservation.ReservationVO;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDAO rDAO;
	
	// 예약확인/취소 리스트
	@Override
	public List<ReservationVO> selectReservationAll(HashMap<String,Object> map) throws Exception {
		return rDAO.selectReservationAll(map);
	}
	
	// 예약 등록
	@Override
	public int insertReservation(ReservationVO rVO) throws Exception {
		return rDAO.insertReservation(rVO);
	}
	
	// 예약확인/취소 취소
	@Override
	public int deleteReservation(Integer rNo) throws Exception {
		return rDAO.deleteReservation(rNo);
	}
	
	// 예약확인/취소 리스트 개수
	@Override
	public int selectReservationCountId(String id) throws Exception {
		return rDAO.selectReservationCountId(id);
	}
	
	// 날짜에 따른 시작 시간 가져오기
	@Override
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception {
		return rDAO.selectReservationTime(rVO);
	}

	// 관리자 예약 확인
	@Override
	public List<ReservationVO> managerreservation(HashMap<String,Object> map) {
		return rDAO.managerreservation(map);
	}
	
	//관리자 예약 확인 리스트
	public int getReservationCount(HashMap<String,Object> map) {
		return rDAO.getReservationCount(map);
	}
	
	
	//관리자 통계
	public List<ReservationVO> getReservationCountByMonth(ReservationVO rVO){
		return rDAO.getReservationCountByMonth(rVO);
	}

	

	

	 
}
