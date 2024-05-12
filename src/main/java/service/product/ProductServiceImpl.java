package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.product.ProductDAO;
import vo.product.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO pDAO;

	// 상품 전체 목록 조회
	@Override
	public List<ProductVO> selectProductAll(int startBoard, int endBoard) throws Exception {
		return pDAO.selectProductAll(startBoard, endBoard);
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

}
