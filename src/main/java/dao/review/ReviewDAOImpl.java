package dao.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.review.ReviewVO;

@Repository("reDAO")
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 리뷰 전체 목록
	@Override
	public List<ReviewVO> selectReviewAll(ReviewVO reviewVO) throws Exception {
		return mybatis.selectList("ReviewDAO.selectReviewAll", reviewVO);
	}

}
