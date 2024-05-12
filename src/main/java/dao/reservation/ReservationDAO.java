package dao.reservation;

import java.util.List;

import vo.product.ProductVO;
import vo.reservation.ReservationVO;

public interface ReservationDAO {
	// 예약 등록
	public void insertReservation(ReservationVO rVO) throws Exception;
	
	// 날짜에 따른 시작 시간 가져오기
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception;
}
