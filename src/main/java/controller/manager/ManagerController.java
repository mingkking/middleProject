package controller.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import service.member.MemberService;
import service.product.ProductService;
import service.reservation.ReservationService;
import vo.member.MemberVO;
import vo.paging.PagingVO;
import vo.product.ProductVO;
import vo.reservation.ReservationVO;

@Controller
public class ManagerController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("manager")
	public String manager() {
		return "manager/manager";
	}
	
	@RequestMapping("managermemberList")
	public String managermemberList(Model m,Integer pageNum,
								String searchCondition,
								String searchKeyword) {
		if(pageNum == null) {
			pageNum =1;
		}
		
		HashMap<String,Object>map = new HashMap<>();
		map.put("searchCondition",searchCondition );
		map.put("searchKeyword", searchKeyword);
		
		int totalRecords = memberService.getMemberCount(map);
		PagingVO paging = new PagingVO(pageNum,totalRecords,10); //한페이지당 보이는 갯수
		map.put("startBoard",paging.getStartBoard()-1);
		map.put("cnt",paging.getCnt());
		
		List<MemberVO> list = memberService.getmemberList(map);
		m.addAttribute("memberList",list);
		m.addAttribute("paging",paging);
		m.addAttribute("searchCondition",searchCondition);
		m.addAttribute("searchKeyword",searchKeyword);
		
		return "manager/managermemberList";
	}
	
	@RequestMapping("managemember")
	public String getmember(MemberVO vo,Model m) {
		
		MemberVO result = memberService.getmember(vo);
		m.addAttribute("member",result);
		
		
		return "manager/managemember";
	}
	
	@RequestMapping("deletemember")
	public String deletemember(MemberVO vo) {
		memberService.deletemember(vo);
		return "redirect:managermemberList";
	}
	
	
	@RequestMapping("managerproduct")
	public String managerproduct(ProductVO vo,Model mo,
									Integer pageNum) {
		if(pageNum == null) {
			pageNum = 1;
		}
		
		HashMap<String,Object> map = new HashMap<>();
		int totalRecords = productService.getProductCount(map);
		PagingVO paging = new PagingVO(pageNum,totalRecords,5); //한 페이지당 보이는 갯수
		map.put("startBoard", paging.getStartBoard()-1);
		map.put("cnt", paging.getCnt());
		
		List<ProductVO> result = productService.managerproduct(map);
		mo.addAttribute("mproductList",result);
		mo.addAttribute("paging",paging);
		
		return "manager/managerproduct";
		
	}
	
	@RequestMapping("managerproductmanaging")
	public String managerproductmanaging(ProductVO vo,Model mo) {
		ProductVO result = productService.managerproductmanaging(vo);
		mo.addAttribute("mproduct",result);
		
		return "manager/managerproductmanaging";
	}
	
	
	@RequestMapping("managerproductInsert")
	public String managerproductInsert(ProductVO vo) {
		return "manager/managerproductInsert";
	}
	
	@RequestMapping("saveProduct")
	public String saveProduct(ProductVO vo) {
		
		productService.insertProduct(vo);
		return "redirect:managerproduct";
	}
	
	@RequestMapping("updateProduct")
	public String updateProduct(ProductVO vo) {
	
		productService.updateProduct(vo);
		return "redirect:managerproduct";
	}
	
	@RequestMapping("deleteProduct")
	
	public String deleteProduct(ProductVO vo){
		productService.deleteProduct(vo);
		return "redirect:managerproduct";
	}
	
	@RequestMapping("managerquestion")
	public String managerquestion() {
		return "manager/managerquestion";
	}
	
	@RequestMapping("managernotice")
	public String managernotice() {
		return "manager/managernotice";
	}
	
	@RequestMapping("managerreservation")
	public String managerreservation(Model m, Integer pageNum,
				String searchCondition,
				String searchKeyword) {
		if(pageNum == null) {
			pageNum = 1;
		}
		
		 HashMap<String, Object> map = new HashMap<>(); 
		 map.put("searchCondition",searchCondition );
		 map.put("searchKeyword", searchKeyword);
		
		 int totalRecords = reservationService.getReservationCount(map);
		 PagingVO paging = new PagingVO(pageNum,totalRecords,10);//한 페이지당 보이는 갯수
		 map.put("startBoard", paging.getStartBoard()-1);
		 map.put("cnt", paging.getCnt());
		 
		 
		 List<ReservationVO> list = reservationService.managerreservation(map); 
		 m.addAttribute("mCheckReservation",list);
		 m.addAttribute("paging",paging);
		 m.addAttribute("searchCondition",searchCondition);
		 m.addAttribute("searchKeyword",searchKeyword);
		 		 
	     return "manager/managerreservation"; 
	}
	
	@RequestMapping("selectReservationCount")
	public String selectReservationCount(){
		
		return "";
	}


	
	@RequestMapping(value = "/managergraph", method = RequestMethod.GET)
	public String managergraph(Model model) {
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		List<Integer> years = new ArrayList<>();
		for(int i = currentYear -5; i <= currentYear + 5;i++) {
			years.add(i);
		}
		model.addAttribute("currentYear",currentYear);
		model.addAttribute("years",years);		
		return "manager/managergraph";
	}
	 
	// ajax 호출 테스트
	@RequestMapping(value = "/ajaxTest", method =  RequestMethod.POST )
	@ResponseBody 
	public List<ReservationVO> ajaxTest(String year,String month) {
		ReservationVO rVO = new ReservationVO();
		System.out.println(year + ',' + month);
		rVO.setYear(year);
		rVO.setMonth(month);
		List<ReservationVO> result =  reservationService.getReservationCountByMonth(rVO);
		System.out.println("------------------------------");
		for(ReservationVO resultVO : result) {
			System.out.println(resultVO.toString());
		}
		return result;
		
	}
	
//	public String managergraph() {
//		List<ReservationVO> list = reservationService.getReservationCountByMonth(rVO);
//		HashMap map = new HashMap();
//		request.setAttribute("list", list);
//		map.put("list",list);
//		String json = null;
//		try {
//			json = new ObjectMapper().writeValueAsString(map);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//					
//			return json;
//		
//		
//		return "manager/managergraph";
//	}
	
	
	
	/*
	 * @RequestMapping("managermemberList") public ModelAndView
	 * openBoardList(Criteria cri)throws Exception{
	 * 
	 * ModelAndView mav = new ModelAndView("managermemberList");
	 * 
	 * PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
	 * pageMaker.setTotalCount(100);
	 * 
	 * List<Map<String,Object>> list = memberService.getmemberList(cri);
	 * mav.addObject("list",list);
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping("manaegrNotice")
	public String managerNotice() {
		return "manager/managerNotice";
	}
	
	
	
	
	
	
	
}
