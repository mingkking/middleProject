package service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.review.ReviewDAO;
import vo.review.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO reDAO;

	@Override
	public List<ReviewVO> selectReviewAll(ReviewVO reviewVO) throws Exception {
		return reDAO.selectReviewAll(reviewVO);
	}
	
	// 리뷰 등록
	@Override
	public int insertReview(ReviewVO reviewVO) throws Exception {
		return reDAO.insertReview(reviewVO);
	}
	
	// 구장번호에 해당하는 리뷰 전체 개수
	@Override
	public int selectReviewCount(ReviewVO reviewVO) throws Exception {
		return reDAO.selectReviewCount(reviewVO);
	}
	
}
