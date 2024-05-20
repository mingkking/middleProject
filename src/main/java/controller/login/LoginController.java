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
import useful.email.MailService;
import useful.popup.PopUp;
import vo.member.MemberVO;

@Controller
@RequiredArgsConstructor
public class LoginController {
	// 서비스 객체 생성
	@Autowired
	private MemberService memberService;

	private MailService mailService;

	private String mail = "";

	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

	// 로그인
	@RequestMapping("/loginCheck")
	public String login(MemberVO vo, HttpSession session, HttpServletResponse response) {
		int result = 0;
		try {
			result = memberService.loginCheck(vo);
		} catch (Exception e) {
			System.out.println("로그인에러: " + e.getMessage());
		}
		if (result == 0) {
			PopUp.popUp(response, "아이디 혹은 비밀번호가 틀렸습니다.");
			return "login/login";
		} else {
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
		memberService.insertMember(vo);

		return "login/login";
	}

	// 마이페이지 화면 이동
	@RequestMapping("/mypage")
	public String mypage(HttpServletResponse response, HttpSession session, MemberVO vo, Model m) {
		String id = (String) session.getAttribute("logid");
		if (id == null) {
			id = "noLogin";
		}
		if (id.equals("noLogin")) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		vo.setId(id);
		vo = memberService.selectMypage(vo);
		m.addAttribute("vo", vo);

		return "login/mypage";
	}

	// 회원 탈퇴
	@RequestMapping("/deleteMypage")
	public String deleteMypage(MemberVO vo, Model m, HttpServletResponse response) {
		int result = memberService.deleteMypage(vo);

		if (result == 1) {
			PopUp.popUpMove(response, "탈퇴가 완료되었습니다.", "logout");
			return "index";
		} else {
			PopUp.popUp(response, "현재 비밀번호가 일치하지 않습니다.");
			m.addAttribute("vo", vo);
			return "login/mypage";
		}

	}

	// 회원 정보 수정
	@RequestMapping("/updateMypage")
	public String updateMypage(MemberVO vo, String password2, Model m, HttpServletResponse response) {
		System.out.println("지금비번: " + vo.getPassword() + " 바꿀 비번: " + password2);

		int result = memberService.selectMypagePw(vo);
		System.out.println("비번일치 결과 값: " + result);
		if (result == 1) {
			if (!(password2 == null || password2 == "")) {
				vo.setPassword(password2);
			}

			int result2 = memberService.updateMypageInfo(vo);
			System.out.println("업데이트 완료: " + result2);
			PopUp.popUpMove(response, "수정되었습니다.", "mypage?id=" + vo.getId());
		} else {
			PopUp.popUpMove(response, "비밀번호가 일치하지 않습니다.", "mypage?id=" + vo.getId());
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
		return String.valueOf(result);
	} // checkTel

	// 이메일 테스트
	@RequestMapping("/sendEmail")
	@ResponseBody
	public String sendEmail(MemberVO vo) throws Exception {
		int result = memberService.selectCheckEmail(vo);
		String str = "";
		String[] str1 = null;
		if (result == 1) {
			mailService = new MailService();
			str = mailService.sendMail(vo.getEmail());
			str1 = str.split(" ");

			for (int i = 0; i < str1.length; i++) {
				if (i == str1.length - 1) {
					this.mail = str1[i];
				}
			}
		}
		return String.valueOf(result);
	} // checkTel

	// 아이디 찾기
	@RequestMapping("/findIdFinal")
	public String findIdFinal(HttpServletResponse response, String emailsearchCode, MemberVO vo, Model m) {
		System.out.println(emailsearchCode);
		System.out.println(this.mail);
		String emailsearchCode1 = emailsearchCode.trim();

		if (emailsearchCode1.equals(this.mail)) {
			vo = memberService.emailCodeId(vo);
			m.addAttribute("id", vo.getId());
			return "login/findIdFinal";
		} else {
			PopUp.popUp(response, "인증번호가 틀렸습니다.");
			return "login/findId";
		}

	} // findIdFinal

	// 비밀번호 찾기 - 인증코드 확인
	@RequestMapping("/findPwFinal")
	public String findPwFinal(HttpServletResponse response, String emailsearchCode, MemberVO vo, Model m) {
		// System.out.println(emailsearchCode);
		// System.out.println(this.mail);
		// System.out.println("입력한 아이디값" + vo.getId());
		// System.out.println("입력한 이메일값" + vo.getEmail());
		String emailsearchCode1 = emailsearchCode.trim();

		// 가입된 정보가 없을 때
		MemberVO vo2 = memberService.selectPw(vo);
		if(vo2 == null) {
			PopUp.popUp(response, "가입된 정보가 없습니다.");
			return "login/findPw";
		}
		
		// 발송된 코드와 입력 코드가 다를 때
		if (emailsearchCode1.equals(this.mail)) {
			vo = memberService.selectPw(vo);
			// m.addAttribute("password", vo.getPassword());
			// System.out.println(vo.toString());
			m.addAttribute("id", vo.getId());
			return "login/findPwFinal";
		} else {
			PopUp.popUp(response, "인증번호가 틀렸습니다.");
			return "login/findPw";
		}
	} // findPwFinal

	// 새 비밀번호 설정
	@RequestMapping("/updateNewPw")
	public String updateNewPw(String newPassword, MemberVO vo, HttpServletResponse response) {
		System.out.println(newPassword);
		vo.setPassword(newPassword);
		memberService.updateNewPw(vo);

		PopUp.popUp(response, "비밀번호가 변경되었습니다.");
		return "login/login";

	}

}
