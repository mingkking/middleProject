package controller.reservation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.product.ProductService;
import service.reservation.ReservationService;
import useful.popup.PopUp;
import vo.member.MemberVO;
import vo.paging.PagingVO;
import vo.product.ProductVO;
import vo.reservation.ReservationVO;

@Controller
public class ReservationController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReservationService reservationService;
	
	// 예약 첫 페이지 이동
	@RequestMapping("/reservation")
	public String reservation(HttpServletResponse response, String id, MemberVO vo, Model model, Integer pageNum) {
		if(id.equals("") || id == null) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
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
			System.out.println("예약 구장 전체 목록: " + e.getMessage()); // 에러났을 때
		}
		
		return "reservation/reservation";
	}
	
	// 예약 두번째 페이지 이동
	@RequestMapping("/reservationForm")
	public String reservationForm(Model model, Integer pNo) {
		
		ProductVO vo = null;
		try {
			vo = productService.selectProduct(pNo); // 예약 페이지 이동 전 상품 상세보기를 위한 vo 가져오기
			model.addAttribute("vo", vo);
			System.out.println(vo.toString());
		} catch (Exception e) {
			System.out.println("예약 구장 Form 및 Detail : " + e.getMessage()); // 에러났을 때
		}
		
		return "reservation/reservationForm";
	}
	
	// 예약등록
	@RequestMapping("/payForm")
	public String reservationList(ReservationVO rVO, String time, String id, Model model) {
		// 예약 시작 시간
		rVO.setStart_time(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1)));
		// 예약 끝나는 시간
		rVO.setEnd_time(String.valueOf(time.charAt(8))+String.valueOf(time.charAt(9)));
		// 아이디 임시
		rVO.setId("jumki12");

		try {
			// 예약 등록 서비스
			reservationService.insertReservation(rVO);
		} catch (Exception e) {
			System.out.println("예약 등록 : " + e.getMessage()); // 에러났을 때
		}
		
		return "reservation/payForm";
	}
	
	// 선택된 날짜에 예약되어 있는 시간들 가져오기
	@RequestMapping("/selectListTime")
	@ResponseBody
	public ArrayList<ReservationVO> selectListTime(ReservationVO rVO, Model model) {
		ArrayList<ReservationVO> list = null;
		
		try {
			list = (ArrayList<ReservationVO>)reservationService.selectReservationTime(rVO);
		} catch (Exception e) {
			System.out.println("예약 날짜에 따른 시간 가져오기 : " + e.getMessage()); // 에러났을 때
		}
		
		return list;
	}
	
	
}
