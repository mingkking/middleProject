package service.reservation;

import java.util.HashMap;
import java.util.List;

import vo.reservation.ReservationVO;

public interface ReservationService {
	// 예약 등록
	public int insertReservation(ReservationVO rVO) throws Exception;

	// 날짜에 따른 시작 시간 가져오기
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception;

	// 관리자 예약 확인
	//public List<ReservationVO> managerreservation(HashMap map);
	
	//관리자 예약확인, 리스트
	int getReservationCount(HashMap<String,Object>map);
	List<ReservationVO> managerreservation(HashMap<String,Object>map);
	
	
	
	//관리자 통계
	public List<ReservationVO> getReservationCountByMonth(ReservationVO rVO);
	
	

}
 