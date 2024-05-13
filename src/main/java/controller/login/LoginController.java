package controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.member.MemberService;
import vo.member.MemberVO;

@Controller
public class LoginController {
	// 서비스 객체 생성
	@Autowired
	private MemberService memberService;

	@RequestMapping("/login")
	public String login() {
		System.out.println("정규열222222222222222");
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
	public String mypage() {
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
		System.out.println("1111111111111111111" + result);
		return String.valueOf(result);
	} // checkTel
}
