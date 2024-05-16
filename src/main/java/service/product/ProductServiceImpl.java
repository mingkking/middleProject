package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.product.ProductDAO;
import vo.product.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO pDAO;

	// 상품 전체 목록 페이징 조회
	@Override
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception {
		return pDAO.selectProductAll(startBoard, endBoard);
	}
	
	// 상품 전체 목록
	@Override
	public List<ProductVO> selectProductAllReview() throws Exception {
		return pDAO.selectProductAllReview();
	}

	// 상품 상세 조회
	@Override
	public ProductVO selectProduct(Integer pNo) throws Exception {
		return pDAO.selectProduct(pNo);
	}

	@Override
	public int selectProductCount() throws Exception {
		return pDAO.selectProductCount();
	}

	// 관리자 상품관리 화면 상품 조회
	public List<ProductVO> managerproduct(ProductVO vo) {
		return pDAO.managerproduct(vo);
	}

	// 관리자 해당 상품관리
	public ProductVO managerproductmanaging(ProductVO vo) {
		return pDAO.managerproductmanaging(vo);
	}

	// 관리자 상품 등록
	public void insertProduct(ProductVO vo) {
		pDAO.insertProduct(vo);
	}

	// 관리자 상품 수정
	public void updateProduct(ProductVO vo) {

		pDAO.updateProduct(vo);
	}

	// 관리자 상품 삭제
	public void deleteProduct(ProductVO vo) {
		pDAO.deleteProduct(vo);
	}


}
