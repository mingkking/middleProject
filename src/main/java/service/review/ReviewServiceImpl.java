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
}
