package service.review;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.review.ReviewDAO;
import vo.review.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO reDAO;

	// 리뷰 전체 페이징 목록
	@Override
	public List<ReviewVO> selectReviewAll(HashMap<String, Integer> map) throws Exception {
		return reDAO.selectReviewAll(map);
	}
	
	// 상품 관련 리뷰 전체  목록
	@Override
	public List<ReviewVO> selectReviewAllNoPaing() throws Exception {
		return reDAO.selectReviewAllNoPaing();
	}
	
	// 상품 관련 리뷰 전체 페이징 목록
	@Override
	public List<ReviewVO> selectReviewAllPaing(HashMap<String, Integer> map) throws Exception {
		return reDAO.selectReviewAllPaing(map);
	}
	
	// 해당 상품 리뷰 개수
	@Override
	public int selectReviewAllNoPaingCount(ReviewVO reviewVO) throws Exception {
		return reDAO.selectReviewAllNoPaingCount(reviewVO);
	}
	
	// 리뷰 등록
	@Override
	public int insertReview(ReviewVO reviewVO) throws Exception {
		return reDAO.insertReview(reviewVO);
	}
	
	// 리뷰 수정
	@Override
	public int updateReview(ReviewVO reviewVO) throws Exception {
		return reDAO.updateReview(reviewVO);
	}
	
	// 구장번호에 해당하는 리뷰 전체 개수
	@Override
	public int selectReviewCount() throws Exception {
		return reDAO.selectReviewCount();
	}

	// 리뷰 삭제
	@Override
	public int deleteReview(ReviewVO reviewVO) throws Exception {
		return reDAO.deleteReview(reviewVO);
	}

	

	

}
