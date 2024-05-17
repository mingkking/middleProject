package service.review;

import java.util.HashMap;
import java.util.List;

import vo.review.ReviewVO;

public interface ReviewService {
	// 리뷰 전체 페이징목록
	public List<ReviewVO> selectReviewAll(HashMap<String, Integer> map) throws Exception;
	
	// 상품 관련 리뷰 전체 목록
	public List<ReviewVO> selectReviewAllNoPaing() throws Exception;
	
	// 상품 관련 리뷰 전체 페이징 목록
	public List<ReviewVO> selectReviewAllPaing(HashMap<String, Integer> map) throws Exception;
	
	// 해당 상품 리뷰 개수
	public int selectReviewAllNoPaingCount(ReviewVO reviewVO) throws Exception;
	
	// 리뷰 등록
	public int insertReview(ReviewVO reviewVO) throws Exception;
	
	// 리뷰 수정
	public int updateReview(ReviewVO reviewVO) throws Exception;
	
	// 구장번호에 해당하는 리뷰 전체 개수
	public int selectReviewCount() throws Exception;
	
	// 리뷰 삭제
	public int deleteReview(ReviewVO reviewVO) throws Exception;
}
