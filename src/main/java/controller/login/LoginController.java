package controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import service.member.MemberService;
import vo.member.MemberVO;

@Controller
@RequiredArgsConstructor
public class LoginController {
	// 서비스 객체 생성
	@Autowired
	private MemberService memberService;

	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

	// 로그인
	@RequestMapping("/loginCheck")
	public String login(MemberVO vo, HttpSession session) {
		int result = 0;
		try {
			result = memberService.loginCheck(vo);
		} catch (Exception e) {
			System.out.println("로그인에러: " + e.getMessage());
		}
		if (result == 0) {
			return "login/login";
		} else {
			System.out.println(vo.getId());
			session.setAttribute("logid", vo.getId());
			return "index";
		}
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "index";
	}

	// 아이디 찾기 화면 이동
	@RequestMapping("/findId")
	public String findId() {
		return "login/findId";
	}

	// 비밀번호 찾기 화면 이동
	@RequestMapping("/findPw")
	public String findPw() {
		return "login/findPw";
	}

	// 회원가입 화면 이동
	@RequestMapping("/insertMemberForm")
	public String insertMemberForm() {
		return "login/insertMemberForm";
	}

	// 회원가입
	@RequestMapping("/insertMember")
	public String loginCheck(MemberVO vo, String tel1, String tel2, String tel3) throws Exception {
		vo.setTel(tel1 + tel2 + tel3);
		System.out.println(vo.toString());
		memberService.insertMember(vo);

		return "login/login";
	}

	// 마이페이지 화면 이동
	@RequestMapping("/mypage")
	public String mypage(MemberVO vo, Model m) {
		if(vo.getId() == null || vo.getId().equals("")) {
			return "login/login";
		}
//		System.out.println(vo.getId());
		vo = memberService.selectMypage(vo);
		m.addAttribute("vo", vo);
		
		return "login/mypage";
	}
	
	// 회원 탈퇴
	@RequestMapping("/deleteMypage")
	public String deleteMypage(MemberVO vo, Model m, HttpServletResponse response) {
//		System.out.println("확인용 아이디: " + vo.getId() + " 확인용 비밀번호: " + vo.getPassword());
		
		int result = memberService.deleteMypage(vo);
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = null;
	        try {
	           out = response.getWriter();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	        
	        out.println("<script>alert('탈퇴가 완료되었습니다.');"
	        		+ "location.href=logout"
	        		+ "</script>");
	        out.flush();
	        
	        return "index";
		}else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = null;
	        try {
	           out = response.getWriter();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	        out.println("<script>alert('현재 비밀번호가 일치하지 않습니다.'); </script>");
	        out.flush();
	        m.addAttribute("vo", vo);
	        return "login/mypage";
		}
		
        
		
	}
	
	// 회원 정보 수정
	@RequestMapping("/updateMypage")
	public String updateMypage(MemberVO vo, String password2, Model m) {
		System.out.println("지금비번: " + vo.getPassword() + " 바꿀 비번: " + password2);
		if(password2 == null || password2.equals("")) {
			memberService.updateMypageInfo(vo);
		} else {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("vo", vo);
			map.put("password2", password2);
			memberService.updateMypage(map);
		}
		
		m.addAttribute("vo", vo);
		return "login/mypage";
	}
	

	// 중복확인
	@RequestMapping("/selectCheckID")
	@ResponseBody
	public String checkId(MemberVO vo) throws Exception {
		int result = memberService.selectCheckID(vo);
		return String.valueOf(result);
	} // checkId

	// 중복확인
	@RequestMapping("/selectCheckTel")
	@ResponseBody
	public String checkTel(MemberVO vo) throws Exception {
		int result = memberService.selectCheckTel(vo);
		return String.valueOf(result);
	} // checkTel

	// 중복확인
	@RequestMapping("/selectCheckEmail")
	@ResponseBody
	public String selectCheckEmail(MemberVO vo) throws Exception {
		int result = memberService.selectCheckEmail(vo);
//		System.out.println("1111111111111111111" + result);
		return String.valueOf(result);
	} // checkTel
	
	
}


