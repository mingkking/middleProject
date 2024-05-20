package controller.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Builder.Default;
import lombok.Value;
import service.member.MemberService;
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
	
	@Autowired
	private MemberService memberService;
	
	// 예약 첫 페이지 이동
	@RequestMapping("/reservation")
	public String reservation(HttpServletResponse response, HttpSession session, MemberVO vo, Model model, Integer pageNum) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		if(pageNum == null || pageNum < 1) {
			pageNum = 1;
		}
		
		PagingVO pVO = null;
		try {
			pVO = new PagingVO(pageNum, productService.selectProductCount(), 6);
			System.out.println("pVO      " + pVO.toString());
			model.addAttribute("pVO", pVO);
		} catch (Exception e1) {
			System.out.println("상품 페이징: " + e1.getMessage()); // 에러났을 때
		}
		
		List<ProductVO> list = null;
		try {
			list = productService.selectProductAll(pVO.getStartBoard(), pVO.getEndBoard()); // 구장 전체 목록
			model.addAttribute("productList", list);
			model.addAttribute("id", id);
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
	public String reservationList(ReservationVO reservationVO, ProductVO productVO, HttpServletResponse response, HttpSession session, String time, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		// 예약 시작 시간
		reservationVO.setStart_time(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1)));
		// 예약 끝나는 시간
		reservationVO.setEnd_time(String.valueOf(time.charAt(8))+String.valueOf(time.charAt(9)));
		// 아이디
		reservationVO.setId(id);
		// 멤버 정보 1개 검색 객체 생성
		MemberVO memberVO = new MemberVO();
		// 멤버 id vo에 지정
		memberVO.setId(id); 
		
		try {
			// 멤버 정보 1개 검색 
			memberVO = memberService.selectMypage(memberVO);
			// 예약 등록 서비스
			//reservationService.insertReservation(rVO);
			
			model.addAttribute("time", time);
			model.addAttribute("reservationVO", reservationVO);
			model.addAttribute("productVO", productVO);
			model.addAttribute("memberVO", memberVO);
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
	
	// 결제 무통장 입금
	@RequestMapping("/insertAccountReservation")
	@ResponseBody
	public String insertAccountReservation(ReservationVO reservationVO, String time, HttpServletResponse response, HttpSession session, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		// 아이디
		reservationVO.setId(id);
		// 예약 시작 시간
		reservationVO.setStart_time(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1)));
		// 예약 끝나는 시간
		reservationVO.setEnd_time(String.valueOf(time.charAt(8))+String.valueOf(time.charAt(9)));
		// 예약 상태
		reservationVO.setrStatus("예약완료");
		// 결제 상태
		reservationVO.setrPayStatus("결제완료");
		
		
		int result = 0;
		try {
			result = reservationService.insertReservation(reservationVO);
		} catch (Exception e) {
			System.out.println("결제 무통장 입금 : " + e.getMessage()); // 에러났을 때
		}
		
		return String.valueOf(result);
	}
	
	
	// 카카오페이 입금
	@RequestMapping("/insertKakaoPayReservation")
	@ResponseBody
	public String insertKakaoPayReservation(ReservationVO reservationVO, String time, HttpServletResponse response, HttpSession session, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		// 아이디
		reservationVO.setId(id);
		// 예약 시작 시간
		reservationVO.setStart_time(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1)));
		// 예약 끝나는 시간
		reservationVO.setEnd_time(String.valueOf(time.charAt(8))+String.valueOf(time.charAt(9)));
		// 예약 상태
		reservationVO.setrStatus("예약완료");
		// 결제 상태
		reservationVO.setrPayStatus("결제완료");
		
		
		int result = 0;
		try {
			result = reservationService.insertReservation(reservationVO);
		} catch (Exception e) {
			System.out.println("결제 카카오페이 입금 : " + e.getMessage()); // 에러났을 때
		}
		
		return String.valueOf(result);
	}
	
	// 핸드폰 입금
	@RequestMapping("/insertPhoneReservation")
	@ResponseBody
	public String insertPhoneReservation(ReservationVO reservationVO, String time, HttpServletResponse response, HttpSession session, Model model) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		// 아이디
		reservationVO.setId(id);
		// 예약 시작 시간
		reservationVO.setStart_time(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1)));
		// 예약 끝나는 시간
		reservationVO.setEnd_time(String.valueOf(time.charAt(8))+String.valueOf(time.charAt(9)));
		// 예약 상태
		reservationVO.setrStatus("예약완료");
		// 결제 상태
		reservationVO.setrPayStatus("결제완료");
		
		int result = 0;
		try {
			result = reservationService.insertReservation(reservationVO);
		} catch (Exception e) {
			System.out.println("결제 핸드폰 입금 : " + e.getMessage()); // 에러났을 때
		}
		
		return String.valueOf(result);
	}
	
	@RequestMapping("/reservationList")
    public String reservationList(HttpServletResponse response, HttpSession session) {
		String id = (String)session.getAttribute("logid");
		if(id == null) {
			id = "noLogin";
		}
		if(id.equals("noLogin")) {
			PopUp.popUpMove(response, "로그인 후 이용가능합니다.", "login");
		}
		
		return "reservation/reservationList";
    }
	
	@RequestMapping("/reservationListAll")
	@ResponseBody
    public HashMap<String,Object> reservationList(ReservationVO reservationVO, HttpSession session, Integer pageNum, Model model) {
		String id = (String)session.getAttribute("logid");
		System.out.println("==================================================================" + pageNum);
		if(pageNum == null || pageNum < 1) {
			pageNum = 1;
		}
		
		PagingVO pagingVO = null;
		ArrayList<ReservationVO> list = null;
		int countList = 0;
		HashMap<String,Object> map = null;
		
		try {
			countList = reservationService.selectReservationCountId(id);
			pagingVO = new PagingVO(pageNum, countList, 10);
			map = new HashMap<String,Object>();
			map.put("startBoard", pagingVO.getStartBoard()-1);
			map.put("endBoard", pagingVO.getEndBoard());
			map.put("startPage", pagingVO.getStartPage());
			map.put("endPage", pagingVO.getEndPage());
			map.put("totalPage", pagingVO.getTotalPage());
			map.put("pageNum", pageNum);
			map.put("id", id);
			System.out.println("=========================================" + pagingVO.toString());
			
			list = new ArrayList<ReservationVO>();
			list = (ArrayList<ReservationVO>) reservationService.selectReservationAll(map);
			map.put("reservationList", list);
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.toString());
			}
		} catch (Exception e) {
			System.out.println("예약확인/취소 : " + e.getMessage()); // 에러났을 때
		}
		
		return map;
    }
    
    @RequestMapping("/deleteReservation")
    @ResponseBody
    public String deleteReservation(Model model, ReservationVO reservationVO) {
    	System.out.println(reservationVO.getrNo());
    	int result = 0;
		try {
			result = reservationService.deleteReservation(reservationVO.getrNo());
		} catch (Exception e) {
			System.out.println("예약취소 : " + e.getMessage()); // 에러났을 때
		}
		
		return String.valueOf(result);
    }
	
}
