package controller.review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.product.ProductService;
import service.review.ReviewService;
import useful.popup.PopUp;
import vo.paging.PagingVO;
import vo.product.ProductVO;
import vo.review.ReviewVO;

@Controller
public class ReviewController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("review")
	public String review(HttpServletResponse response, String id, Integer pageNum, ReviewVO reviewVO, ProductVO productVO, Model model) {
		if(id.equals("") || id == null) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		// 상품
		if(pageNum == null) {
			pageNum = 1;
		}
		
		PagingVO pVO = null;
		try {
			pVO = new PagingVO(pageNum, productService.selectProductCount());
			model.addAttribute("pVO", pVO);
		} catch (Exception e1) {
			System.out.println("상품 페이징: " + e1.getMessage()); // 에러났을 때
		}
		
		List<ProductVO> list = null;
		try {
			list = productService.selectProductAll(pVO.getStartBoard(), pVO.getEndBoard()); // 구장 전체 목록
			model.addAttribute("productList", list);
			/* model.addAttribute("pNo", pNo); */
		} catch (Exception e) {
			System.out.println("상품 구장 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		
		// 초기 상품 1개 검색 및 해당상품 검색
		try {
			if(productVO.getpNo() == null || productVO.getpNo() == 0) { // 상품 번호가 없을 경우
				productVO.setpNo(1); // 초기 화면 상품 번호 1로 세팅
			}
			productVO = productService.selectProduct(productVO.getpNo()); // 상품 1개 검색
			model.addAttribute("productVO", productVO); // 상품 1개 담기
		} catch (Exception e1) {
			System.out.println("상품 구장 1개: " + e1.getMessage()); // 에러났을 때
		}
		
		// 리뷰
		System.out.println(reviewVO.getpNo());
		try {
			List<ReviewVO> reviewList = reviewService.selectReviewAll(reviewVO);
			model.addAttribute("reviewList", reviewList);
		} catch (Exception e) {
			System.out.println("리뷰 구장 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		
		return "review/review";
	}
}
