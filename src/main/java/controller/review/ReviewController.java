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
		model.addAttribute("id", id);
		
		// 리뷰 페이징
		if(pageNum == null) {
			pageNum = 1;
		}
		
		PagingVO pVO = null;
		try {
			pVO = new PagingVO(pageNum, reviewService.selectReviewCount(), 12);
			
			model.addAttribute("pVO", pVO);
			model.addAttribute("pageNum", pageNum);
		} catch (Exception e1) {
			System.out.println("리뷰 페이징: " + e1.getMessage()); // 에러났을 때
		}
		
		// 리뷰
		try {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("startBoard", pVO.getStartBoard()-1);
			map.put("endBoard", pVO.getEndBoard());
			System.out.println("리뷰 페이징2 " + map.get("startBoard") + "리뷰 페이징2 " + map.get("endBoard"));
			List<ReviewVO> reviewList = reviewService.selectReviewAll(map);
			model.addAttribute("reviewList", reviewList);
		} catch (Exception e) {
			System.out.println("리뷰 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		
		return "review/review";
	}
	
	@RequestMapping("/insertReview")
	public String insertReview(ReviewVO reviewVO, Integer pageNum, HttpServletResponse response, String emailAddr) {
		System.out.println("111111111111111111111");
		try {
			int result = reviewService.insertReview(reviewVO);
			if(result == 1) {
				PopUp.popUpMove(response, "리뷰 등록이 완료되었습니다.", "review?id=" + reviewVO.getId() + "&pNo=" + reviewVO.getpNo() + "&pageNum=" + pageNum);
			}
		} catch (Exception e) {
			System.out.println("리뷰 등록 : " + e.getMessage()); // 에러났을 때
		}
		
		return "forward:review";
	}
}
