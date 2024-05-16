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

	@Override
	// 예약 등록
	public void insertReservation(ReservationVO rVO) throws Exception {
		mybatis.insert("ReservationDAO.insertReservation", rVO);
	}

	// 날짜에 따른 시작 시간 가져오기
	@Override
	public List<ReservationVO> selectReservationTime(ReservationVO rVO) throws Exception {
		return mybatis.selectList("ReservationDAO.selectReservationTime", rVO);
	}

	// 관리자 예약확인
	public List<ReservationVO> managerreservation(HashMap map) {
		List<ReservationVO> list = mybatis.selectList("ReservationDAO.managerreservation", map);

		return list;
	}

	// 예약갯수
	public int selectReservationCount() throws Exception {
		return mybatis.selectOne("ReservationDAO.selectReservationCount");
	}

	//관리자 통계
	public List<ReservationVO> getReservationCountByMonth(ReservationVO rVO){
		return mybatis.selectList("ReservationDAO.getReservationCountByMonth",rVO);
	}


}
