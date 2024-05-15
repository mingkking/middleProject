package service.review;

import java.util.HashMap;
import java.util.List;

import vo.review.ReviewVO;

public interface ReviewService {
	// 리뷰 전체 목록
	public List<ReviewVO> selectReviewAll(HashMap<String, Integer> map) throws Exception;
	
	// 리뷰 등록
	public int insertReview(ReviewVO reviewVO) throws Exception;
	
	// 구장번호에 해당하는 리뷰 전체 개수
	public int selectReviewCount() throws Exception;
}
