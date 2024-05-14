package service.product;

import java.util.List;

import vo.product.ProductVO;

public interface ProductService {
	// 상품 전체 목록 조회
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception;

	// 상품 상세 조회
	public ProductVO selectProduct(Integer pNo) throws Exception;

	// 상품 개수
	public int selectProductCount() throws Exception;

	// 관리자 상품 목록 조회
	public List<ProductVO> managerproduct(ProductVO vo);

	// 관리자 해당 상품 관리
	ProductVO managerproductmanaging(ProductVO vo);

	void insertProduct(ProductVO vo);

	void updateProduct(ProductVO vo);

	void deleteProduct(ProductVO vo);
}
