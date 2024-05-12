package dao.product;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.product.ProductVO;

@Repository("pDAO")
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SqlSessionTemplate mybatis;

	// 상품 전체 목록 조회
	@Override
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("startBoard", startBoard - 1);
		map.put("endBoard", endBoard);
		
		return mybatis.selectList("ProductDAO.selectProductAll", map);
	}
	
	// 상품 상세 조회
	@Override
	public ProductVO selectProduct(Integer pNo) throws Exception {
		return mybatis.selectOne("ProductDAO.selectProduct", pNo);
	}
	
	// 상품 개수
	@Override
	public int selectProductCount() throws Exception {
		return mybatis.selectOne("ProductDAO.selectProductCount");
	}

	
	
}
