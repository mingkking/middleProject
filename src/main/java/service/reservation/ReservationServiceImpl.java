package service.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.product.ProductDAO;
import dao.reservation.ReservationDAO;
import vo.product.ProductVO;
import vo.reservation.ReservationVO;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDAO rDAO;

	// 예약 등록
	@Override
	public void insertReservation(ReservationVO rVO) throws Exception {
		rDAO.insertReservation(rVO);
	}

	// 날짜에 따른 시작 시간 가져오기
	@Override
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception {
		return rDAO.selectReservationTime(rVO);
	}


}
