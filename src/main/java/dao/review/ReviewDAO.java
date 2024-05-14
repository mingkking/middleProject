package dao.review;

import java.util.List;
import vo.review.ReviewVO;

public interface ReviewDAO {
	// 리뷰 전체 목록
	public List<ReviewVO> selectReviewAll(ReviewVO reviewVO) throws Exception;
}
