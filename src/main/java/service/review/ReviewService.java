package service.review;

import java.util.List;

import vo.review.ReviewVO;

public interface ReviewService {
	// 리뷰 전체 목록
	public List<ReviewVO> selectReviewAll(ReviewVO reviewVO) throws Exception;
}
