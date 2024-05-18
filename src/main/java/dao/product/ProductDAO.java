package dao.product;

import java.util.HashMap;
import java.util.List;

import vo.product.ProductVO;

public interface ProductDAO {
	// 상품 전체 목록 페이징
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception;
	
	// 상품 전체 목록
	public List<ProductVO> selectProductAllReview() throws Exception;
	
	// 상품 상세 조회
	public ProductVO selectProduct(Integer pNo) throws Exception;

	// 상품 개수
	public int selectProductCount() throws Exception;

	// 관리자 상품관리 상품 조회,페이징화
	List<ProductVO> managerproduct(HashMap<String,Object>map);
	int getProductCount(HashMap<String,Object>map);
	
	
	// 관리자 해당 상품 관리
	public ProductVO managerproductmanaging(ProductVO vo);

	// 관리자 상품 등록
	public void insertProduct(ProductVO vo);

	// 관리자 상품 수정
	public void updateProduct(ProductVO vo);

	// 관리자 상품 삭제
	public void deleteProduct(ProductVO vo);
	
}
