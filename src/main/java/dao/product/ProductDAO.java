package dao.product;

import java.util.List;

import vo.product.ProductVO;

public interface ProductDAO {
	// 상품 전체 목록
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception;
	
	// 상품 상세 조회
	public ProductVO selectProduct(Integer pNo) throws Exception;
	
	// 상품 개수
	public int selectProductCount() throws Exception;
}
