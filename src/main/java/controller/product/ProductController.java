package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.product.ProductService;
import useful.popup.PopUp;
import vo.member.MemberVO;
import vo.paging.PagingVO;
import vo.product.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/coming")
	public String coming(HttpServletResponse response, Model model, Integer pNo, Integer pageNum) {
		List<ProductVO> list = null;
		
		if(pNo == null) {
			pNo = 1;
		}
		
		if(pageNum == null) {
			pageNum = 1;
		}
		
		PagingVO pVO = null;
		try {
			pVO = new PagingVO(pageNum, productService.selectProductCount(), 6);
			model.addAttribute("pVO", pVO);
		} catch (Exception e1) {
			System.out.println("상품 페이징: " + e1.getMessage()); // 에러났을 때
		}
		
		try {
			list = productService.selectProductAll(pVO.getStartBoard(), pVO.getEndBoard()); // 구장 전체 목록
			model.addAttribute("productList", list);
			model.addAttribute("pNo", pNo);
		} catch (Exception e) {
			System.out.println("구장 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		
		return "product/coming";
		
	}
	
	// 객체를 반환
	@RequestMapping("/productDetail")
	@ResponseBody
	public ProductVO productDetail(Integer pNo) {
		ProductVO vo = null;
		
		try {
			vo = productService.selectProduct(pNo);
		} catch (Exception e) {
			System.out.println("상품 상세 조회: " + e.getMessage()); // 에러났을 때
		}
		
		return vo;
	}
}
