package controller.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.product.ProductService;
import service.review.ReviewService;
import useful.email.MailService;
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
	
	private MailService mailService = null;
	
	@RequestMapping("/review")
	public String review(HttpServletResponse response, String id, Integer pageNum, ReviewVO reviewVO, ProductVO productVO, Model model) {
		if(id.equals("") || id == null) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		ArrayList<ProductVO> productList = null;
		PagingVO pVO = null;
		List<ReviewVO> reviewList = null;
		List<ReviewVO> reviewListNoPaging = null;
		
		// 리뷰 페이징 초기 세팅
		if(pageNum == null) {
			pageNum = 1;
		}
		
		// 리뷰
		try {
			productList = new ArrayList<ProductVO>(); // 상품 리스트 객체 생성
			productList = (ArrayList<ProductVO>) productService.selectProductAllReview(); // 모든 상품 가져오기
			pVO = new PagingVO(pageNum, reviewService.selectReviewCount(), 12); // 페이지 세팅
			
			System.out.println("pVO : " + pVO.toString()); // 페이지 확인
			
			HashMap<String, Integer> map = new HashMap<String, Integer>(); // 리뷰리스트의 페이지당 게시물을 출력하기 위한 맵 생성
			map.put("startBoard", pVO.getStartBoard()-1); // 맵에 시작 게시물 저장
			map.put("endBoard", pVO.getEndBoard());       // 맵에 끝에 게시물 저장
			
			System.out.println("리뷰 페이징2 " + map.get("startBoard") + "리뷰 페이징2 " + map.get("endBoard")); // 맵 값 확인
			
			reviewList = new ArrayList<ReviewVO>(); // 리뷰 리스트 객체 생성
			reviewList = reviewService.selectReviewAll(map); // 리뷰 게시물을 해당페이지당 12개씩 가져오기
			reviewListNoPaging = reviewService.selectReviewAllNoPaing(); // 리뷰 게시물을 페이징 없이 가져오기
			productVO = productService.selectProduct(reviewVO.getpNo()); // 리뷰 사진 클릭 시 해당 상풍번호에 대한 상품정보 가져오기
		} catch (Exception e) {
			System.out.println("리뷰 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		model.addAttribute("id", id); // session id 저장
		model.addAttribute("productList", productList); // 상품 리스트 전체
		model.addAttribute("pVO", pVO); // 페이징객체 저장
		model.addAttribute("pageNum", pageNum); // 현재 페이징 번호
		model.addAttribute("reviewList", reviewList); // 리뷰 리스트 페이징 완료
		model.addAttribute("reviewListNoPaging", reviewListNoPaging); // 리뷰 리스트
		model.addAttribute("pNo", reviewVO.getpNo()); // 상품 클릭시 상품번호 저장
		model.addAttribute("productVO", productVO); // 리뷰 사진 클릭 시 해당 상풍번호에 대한 상품정보 저장
		
		return "review/review";
	}
	
	@RequestMapping("/insertReview")
	public String insertReview(ReviewVO reviewVO, Integer pageNum, HttpServletResponse response, Model model) {
		System.out.println("111111111111111111111 " + reviewVO.toString());
		try {
			int result = reviewService.insertReview(reviewVO);
			if(result == 1) {
				ProductVO productVO = productService.selectProduct(reviewVO.getpNo());
				model.addAttribute("productVO", productVO);
				PopUp.popUpMove(response, "리뷰 등록이 완료되었습니다.", "review?id=" + reviewVO.getId() + "&pNo=" + reviewVO.getpNo() + "&pageNum=" + pageNum);
			}
			 
		} catch (Exception e) {
			System.out.println("리뷰 등록 : " + e.getMessage()); // 에러났을 때
		}
		
		return "redirect:review";
	}
}
