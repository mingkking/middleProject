package controller.manager;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String managermemberList(Model m,
								String searchCondition,
								String searchKeyword) {
		HashMap map = new HashMap();
		map.put("searchCondition",searchCondition );
		map.put("searchKeyword", searchKeyword);
		
		List<MemberVO> list = memberService.getmemberList(map);
		
		m.addAttribute("memberList",list);
		
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
	public String managerproduct(ProductVO vo,Model mo) {
		List<ProductVO> result = productService.managerproduct(vo);
		mo.addAttribute("mproductList",result);
		
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
		
		
		
		 HashMap map = new HashMap(); 
		 map.put("searchCondition",searchCondition );
		 map.put("searchCondition", searchCondition);
		 
		  
		 List<ReservationVO> list = reservationService.managerreservation(map);
		 
		 m.addAttribute("mCheckReservation",list);
		 
	     return "manager/managerreservation"; 
	}
	
	@RequestMapping("selectReservationCount")
	public String selectReservationCount() {
		return "";
	}

	@RequestMapping("managergraph")
	public String managergraph() {
		return "manager/managergraph";
	}
	
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
