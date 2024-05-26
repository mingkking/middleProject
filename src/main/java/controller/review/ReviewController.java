package controller.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public String review(HttpServletResponse response, HttpSession session, Integer pageNum, Integer pageNum2, ReviewVO reviewVO, ProductVO productVO, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		ArrayList<ProductVO> productList = null;
		PagingVO pVO = null;
		List<ReviewVO> reviewList = null;
		List<ReviewVO> reviewListNoPaging = null;
		List<ReviewVO> reviewListPaging = null;
		PagingVO pVO2 = null;
		
		// 리뷰 페이징 초기 세팅
		if(pageNum == null) {
			pageNum = 1;
		}
		
		// 리뷰 페이징 초기 세팅
		if(pageNum2 == null) {
			pageNum2 = 1;
		}
		
		// 리뷰
		try {
			productList = new ArrayList<ProductVO>(); // 상품 리스트 객체 생성
			productList = (ArrayList<ProductVO>) productService.selectProductAllReview(); // 모든 상품 가져오기
			pVO = new PagingVO(pageNum, reviewService.selectReviewCount(), 12); // 페이지 세팅
						
			HashMap<String, Integer> map = new HashMap<String, Integer>(); // 리뷰리스트의 페이지당 게시물을 출력하기 위한 맵 생성
			map.put("startBoard", pVO.getStartBoard()-1); // 맵에 시작 게시물 저장
			map.put("endBoard", pVO.getEndBoard());       // 맵에 끝에 게시물 저장
			
			reviewList = new ArrayList<ReviewVO>(); // 리뷰 리스트 객체 생성
			reviewList = reviewService.selectReviewAll(map); // 리뷰 게시물을 해당페이지당 12개씩 가져오기
			reviewListNoPaging = reviewService.selectReviewAllNoPaing(); // 리뷰 게시물을 페이징 없이 가져오기
			productVO = productService.selectProduct(reviewVO.getpNo()); // 리뷰 사진 클릭 시 해당 상풍번호에 대한 상품정보 가져오기
			
			pVO2 = new PagingVO(pageNum2, reviewService.selectReviewAllNoPaingCount(reviewVO), 5); // 페이징 객체 생성
			
			HashMap<String, Integer> map2 = new HashMap<String, Integer>(); // 리뷰리스트의 페이지당 게시물을 출력하기 위한 맵 생성
			map2.put("startBoard2", pVO2.getStartBoard()-1); // 맵에 시작 게시물 저장
			map2.put("endBoard2", pVO2.getEndBoard());       // 맵에 끝에 게시물 저장
			map2.put("pNo", reviewVO.getpNo());				 // 맵에 상품번호 저장
						
			reviewListPaging = new ArrayList<ReviewVO>(); // 리뷰 리스트 페이징할 객체 생성
			reviewListPaging = reviewService.selectReviewAllPaing(map2); // 해당 상품번호 관련 리뷰리스트 페이징 서비스 실행
		} catch (Exception e) {
			System.out.println("리뷰 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		model.addAttribute("productList", productList); // 상품 리스트 전체
		
		model.addAttribute("pVO", pVO); // 페이징객체 저장
		model.addAttribute("pageNum", pageNum); // 현재 페이징 번호
		model.addAttribute("reviewList", reviewList); // 리뷰 리스트 페이징 완료
		model.addAttribute("reviewListNoPaging", reviewListNoPaging); // 리뷰 리스트
		
		model.addAttribute("pNo", reviewVO.getpNo()); // 상품 클릭시 상품번호 저장
		model.addAttribute("productVO", productVO); // 리뷰 사진 클릭 시 해당 상풍번호에 대한 상품정보 저장
		
		model.addAttribute("pVO2", pVO2); // 두번째 페이징객체 저장
		model.addAttribute("pageNum2", pageNum2); // 두번째 현재 페이징 번호
		model.addAttribute("reviewListPaging", reviewListPaging); //해당 상품번호 관련 리뷰리스트 페이징 서비스 저장
		
		return "review/review";
	}
	
	@RequestMapping("/insertReview")
	public String insertReview(ReviewVO reviewVO, HttpSession session, Integer pageNum, HttpServletResponse response, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			return "login/login";
		}
		reviewVO.setId(id);
		
		int result = 0;
		ProductVO productVO = null;
		
		try {
			result = reviewService.insertReview(reviewVO);
			productVO = productService.selectProduct(reviewVO.getpNo());
		} catch (Exception e) {
			System.out.println("리뷰 등록 : " + e.getMessage()); // 에러났을 때
		}
		
		model.addAttribute("productVO", productVO);
		
		return "redirect:/review?pNo=" + reviewVO.getpNo() + "&pageNum=" + pageNum;
	}
	
	@RequestMapping("/updateReview")
	@ResponseBody
	public ReviewVO updateReview(HttpSession session, ReviewVO reviewVO, Integer rNo, Integer pNo, String rTitle, String rContent) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		reviewVO.setrNo(rNo);
		reviewVO.setpNo(pNo);
		reviewVO.setId(id);
		reviewVO.setrTitle(rTitle);
		reviewVO.setrContent(rContent);
		
		System.out.println(reviewVO.toString());
		
		try {
			reviewService.updateReview(reviewVO);
		} catch (Exception e) {
			System.out.println("리뷰 수정 : " + e.getMessage()); // 에러났을 때
		}
		
		return reviewVO;
	}
	
	@RequestMapping("/deleteReview")
	@ResponseBody
	public ReviewVO deleteReview(HttpSession session, ReviewVO reviewVO, Integer rNo) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		reviewVO.setrNo(rNo);
		reviewVO.setId(id);
		
		System.out.println(reviewVO.toString());
		
		try {
			reviewService.deleteReview(reviewVO);
		} catch (Exception e) {
			System.out.println("리뷰 삭제 : " + e.getMessage()); // 에러났을 때
		}
		
		return reviewVO;
	}
	
}
