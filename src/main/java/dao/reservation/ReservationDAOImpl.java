package dao.reservation;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.product.ProductVO;
import vo.reservation.ReservationVO;

@Repository("rDAO")
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 예약확인/취소 리스트
	@Override
	public List<ReservationVO> selectReservationAll(HashMap<String,Object> map) throws Exception {
		return mybatis.selectList("ReservationDAO.selectReservationAll", map);
	}
	
	@Override
	// 예약 등록
	public int insertReservation(ReservationVO rVO) throws Exception {
		return mybatis.insert("ReservationDAO.insertReservation", rVO);
	}
	
	// 예약확인/취소 취소
	@Override
	public int deleteReservation(Integer rNo) throws Exception {
		return mybatis.delete("ReservationDAO.deleteReservation", rNo);
	}
	
	// 예약확인/취소 리스트 개수
	@Override
	public int selectReservationCountId(String id) throws Exception {
		return mybatis.selectOne("ReservationDAO.selectReservationCountId", id);
	}

	// 날짜에 따른 시작 시간 가져오기
	@Override
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception {
		return mybatis.selectList("ReservationDAO.selectReservationTime", rVO);
	}

	// 관리자 예약확인
	public List<ReservationVO> managerreservation(HashMap<String,Object> map) {
		List<ReservationVO> list = mybatis.selectList("ReservationDAO.managerreservation", map);

		return list;
	}

	//관리자 예약확인 리스트
	public int getReservationCount(HashMap<String,Object>map) {
		return mybatis.selectOne("ReservationDAO.getReservationCount",map);
	}

	//관리자 통계 
	public List<ReservationVO> getReservationCountByMonth(ReservationVO rVO){
		return mybatis.selectList("ReservationDAO.getReservationCountByMonth",rVO);
	}



}
