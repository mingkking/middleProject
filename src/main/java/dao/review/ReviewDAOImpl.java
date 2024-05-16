package dao.review;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.review.ReviewVO;

@Repository("reDAO")
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 리뷰 전체 페이징 목록
	@Override
	public List<ReviewVO> selectReviewAll(HashMap<String, Integer> map) throws Exception {
		return mybatis.selectList("ReviewDAO.selectReviewAll", map);
	}
	
	// 리뷰 전체 목록
	@Override
	public List<ReviewVO> selectReviewAllNoPaing() throws Exception {
		return mybatis.selectList("ReviewDAO.selectReviewAllNoPaing");
	}
	
	// 리뷰 등록
	@Override
	public int insertReview(ReviewVO reviewVO) throws Exception {
		return mybatis.insert("ReviewDAO.insertReview", reviewVO);
	}

	// 구장번호에 해당하는 리뷰 전체 개수
	@Override
	public int selectReviewCount() throws Exception {
		return mybatis.selectOne("ReviewDAO.selectReviewCount");
	}
	
}
