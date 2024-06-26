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
	
	// 상품 관련 리뷰 전체 목록
	@Override
	public List<ReviewVO> selectReviewAllNoPaing() throws Exception {
		return mybatis.selectList("ReviewDAO.selectReviewAllNoPaing");
	}
	
	// 상품 관련 리뷰 전체 페이징 목록
	@Override
	public List<ReviewVO> selectReviewAllPaing(HashMap<String, Integer> map) throws Exception {
		return mybatis.selectList("ReviewDAO.selectReviewAllPaing", map);
	}
	
	// 해당 상품 리뷰 개수
	@Override
	public int selectReviewAllNoPaingCount(ReviewVO reviewVO) throws Exception {
		return mybatis.selectOne("ReviewDAO.selectReviewAllNoPaingCount", reviewVO);
	}
	
	// 리뷰 등록
	@Override
	public int insertReview(ReviewVO reviewVO) throws Exception {
		return mybatis.insert("ReviewDAO.insertReview", reviewVO);
	}
	
	// 리뷰 수정
	@Override
	public int updateReview(ReviewVO reviewVO) throws Exception {
		return mybatis.update("ReviewDAO.updateReview", reviewVO);
	}
	
	// 구장번호에 해당하는 리뷰 전체 개수
	@Override
	public int selectReviewCount() throws Exception {
		return mybatis.selectOne("ReviewDAO.selectReviewCount");
	}

	// 리뷰 삭제
	@Override
	public int deleteReview(ReviewVO reviewVO) throws Exception {
		return mybatis.delete("ReviewDAO.deleteReview", reviewVO);
	}

	

	

	
	
}
