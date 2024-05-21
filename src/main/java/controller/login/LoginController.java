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
	// 멤버 서비스 객체 생성
	@Autowired
	private MemberService memberService;

	// useful 클래스 객체 생성 (메일 인증 시 필요)
	private MailService mailService;
	
	// 메일 인증할 때 인증코드 저장하기 위한 변수
	private String mail = "";

	// 메인페이지 화면에서 로그인 탭 눌렀을 때 로그인 화면 이동
	@RequestMapping("/login")
	public String login() {
		// 로그인 페이지로 이동
		return "login/login";
	}

	// 로그인 화면에서 member 아이디 패스워드 비교
	@RequestMapping("/loginCheck")
	public String login(MemberVO vo, HttpSession session, HttpServletResponse response) {
		// DB에서 조회한 결과 값을 저장하기 위한 변수
		int result = 0;
		try {
			// member 서비스 로그인 기능
			result = memberService.loginCheck(vo);
		} catch (Exception e) {
			// 로그인할 때 에러 시 에러내용 확인
			System.out.println("로그인에러: " + e.getMessage());
		}
		
		// 로그인 기능 후 결과 값이 0 일 경우
		if (result == 0) {
			// 아이디 혹은 비밀번호가 틀렸다는 팝업 표시
			PopUp.popUp(response, "아이디 혹은 비밀번호가 틀렸습니다.");
			return "login/login";
		} else { // 로그인 기능 후 결과 값이 0 이외의 값일 경우
			// 일치하는 아이디를 세션 logid 에다 저장
			session.setAttribute("logid", vo.getId());
			// 메인 페이지 이동
			return "index";
		}
	}

	// 메인페이지에서 로그아웃 탭 클릭 시
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 모든 세션 값 삭제
		session.invalidate();
		// 메인 페이지 이동
		return "index";
	}

	// 아이디 찾기 화면 이동
	@RequestMapping("/findId")
	public String findId() {
		// 아이디 찾기 페이지로 이동
		return "login/findId";
	}

	// 비밀번호 찾기 화면 이동
	@RequestMapping("/findPw")
	public String findPw() {
		// 비밀번호 찾기 페이지로 이동
		return "login/findPw";
	}

	// 회원가입 화면 이동
	@RequestMapping("/insertMemberForm")
	public String insertMemberForm() {
		// 회원가입 페이지로 이동
		return "login/insertMemberForm";
	}

	// 회원가입
	@RequestMapping("/insertMember")
	public String insertMember(MemberVO vo, String tel1, String tel2, String tel3) throws Exception {
		// 회원가입 화면의 전화번호 3개 값을 1개로 합치기
		vo.setTel(tel1 + tel2 + tel3);
		// 회원 가입 기능 실행
		memberService.insertMember(vo);

		// 회원 가입 후 로그인 화면으로 이동
		return "login/login";
	}

	// 마이페이지 화면 이동
	@RequestMapping("/mypage")
	public String mypage(HttpServletResponse response, HttpSession session, MemberVO vo, Model m) {
		// 세션에 logid 값을 id 에 저장
		String id = (String) session.getAttribute("logid");
		
		// id 값이 없을 경우
		if (id == null) {
			// id 에 noLogin 문자열 저장
			id = "noLogin";
		}
		
		// id 값이 noLogin 인 경우
		if (id.equals("noLogin")) {
			// useful 패키지에 있는 PopUp 클래스 안 popUp 메소드를 실행하여 alert 띄우기
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			// 로그인 화면 이동
			return "login/login";
		}
		
		// MemberVO vo 값에 id 저장
		vo.setId(id);
		
		// DB에서 조회한 마이페이지 정보 vo 객체에 저장
		vo = memberService.selectMypage(vo);
		// Model 객체에 vo 객체 추가
		m.addAttribute("vo", vo);

		// 마이페이지 화면으로 이동
		return "login/mypage";
	}

	// 회원 탈퇴
	@RequestMapping("/deleteMypage")
	public String deleteMypage(MemberVO vo, Model m, HttpServletResponse response) {
		// 회원 탈퇴 기능 실행 결과 저장
		int result = memberService.deleteMypage(vo);

		if (result == 1) {
			// 탈퇴 성공 시 팝업 표시 후 로그아웃
			PopUp.popUpMove(response, "탈퇴가 완료되었습니다.", "logout");
			return "index";
		} else {
			// 탈퇴 실패 시 팝업 표시
			PopUp.popUp(response, "현재 비밀번호가 일치하지 않습니다.");
			m.addAttribute("vo", vo);
			return "login/mypage";
		}

	}

	// 회원 정보 수정
	@RequestMapping("/updateMypage")
	public String updateMypage(MemberVO vo, String password2, Model m, HttpServletResponse response) {
		System.out.println("지금비번: " + vo.getPassword() + " 바꿀 비번: " + password2);

		// 현재 비밀번호 확인 결과 저장
		int result = memberService.selectMypagePw(vo);
		System.out.println("비번일치 결과 값: " + result);
		if (result == 1) {
			// 새 비밀번호가 입력된 경우 변경
			if (!(password2 == null || password2.equals(""))) {
				vo.setPassword(password2);
			}

			// 회원 정보 수정 기능 실행 결과 저장
			int result2 = memberService.updateMypageInfo(vo);
			System.out.println("업데이트 완료: " + result2);
			// 수정 완료 팝업 표시 후 마이페이지로 이동
			PopUp.popUpMove(response, "수정되었습니다.", "mypage?id=" + vo.getId());
		} else {
			// 비밀번호 불일치 팝업 표시 후 마이페이지로 이동
			PopUp.popUpMove(response, "비밀번호가 일치하지 않습니다.", "mypage?id=" + vo.getId());
		}

		m.addAttribute("vo", vo);
		return "login/mypage";
	}

	// 아이디 중복 확인
	@RequestMapping("/selectCheckID")
	@ResponseBody
	public String checkId(MemberVO vo) throws Exception {
		// 아이디 중복 확인 결과 반환
		int result = memberService.selectCheckID(vo);
		return String.valueOf(result);
	} // checkId

	// 전화번호 중복 확인
	@RequestMapping("/selectCheckTel")
	@ResponseBody
	public String checkTel(MemberVO vo) throws Exception {
		// 전화번호 중복 확인 결과 반환
		int result = memberService.selectCheckTel(vo);
		return String.valueOf(result);
	} // checkTel

	// 이메일 중복 확인
	@RequestMapping("/selectCheckEmail")
	@ResponseBody
	public String selectCheckEmail(MemberVO vo) throws Exception {
		// 이메일 중복 확인 결과 반환
		int result = memberService.selectCheckEmail(vo);
		return String.valueOf(result);
	} // selectCheckEmail

	// 이메일 인증 코드 전송
	@RequestMapping("/sendEmail")
	@ResponseBody
	public String sendEmail(MemberVO vo) throws Exception {
		// 이메일 중복 확인 결과
		int result = memberService.selectCheckEmail(vo);
		String str = "";
		String[] str1 = null;
		if (result == 1) {
			// 메일 서비스 객체 생성
			mailService = new MailService();
			// 인증 코드 발송
			str = mailService.sendMail(vo.getEmail());
			str1 = str.split(" ");

			for (int i = 0; i < str1.length; i++) {
				// 마지막 부분이 인증 코드
				if (i == str1.length - 1) {
					this.mail = str1[i];
				}
			}
		}
		return String.valueOf(result);
	} // sendEmail

	// 아이디 찾기 - 인증 코드 확인
	@RequestMapping("/findIdFinal")
	public String findIdFinal(HttpServletResponse response, String emailsearchCode, MemberVO vo, Model m) {
		// 입력된 인증 코드 공백 제거
		String emailsearchCode1 = emailsearchCode.trim();

		// 입력된 인증 코드와 발송된 코드가 일치하는 경우
		if (emailsearchCode1.equals(this.mail)) {
			// 아이디 조회
			vo = memberService.emailCodeId(vo);
			// Model 객체에 아이디 추가
			m.addAttribute("id", vo.getId());
			// 아이디 찾기 완료 페이지로 이동
			return "login/findIdFinal";
		} else {
			// 인증 코드 불일치 팝업 표시
			PopUp.popUp(response, "인증번호가 틀렸습니다.");
			return "login/findId";
		}
	} // findIdFinal

	// 비밀번호 찾기 - 인증 코드 확인
	@RequestMapping("/findPwFinal")
	public String findPwFinal(HttpServletResponse response, String emailsearchCode, MemberVO vo, Model m) {
		// 입력된 인증 코드 공백 제거
		String emailsearchCode1 = emailsearchCode.trim();

		// 가입된 정보가 없는 경우
		MemberVO vo2 = memberService.selectPw(vo);
		if (vo2 == null) {
			PopUp.popUp(response, "가입된 정보가 없습니다.");
			return "login/findPw";
		}
		
		// 인증 코드 일치 시
		if (emailsearchCode1.equals(this.mail)) {
			vo = memberService.selectPw(vo);
			m.addAttribute("id", vo.getId());
			return "login/findPwFinal";
		} else {
			// 인증 코드 불일치 팝업 표시
			PopUp.popUp(response, "인증번호가 틀렸습니다.");
			return "login/findPw";
		}
	} // findPwFinal

	// 새 비밀번호 설정
	@RequestMapping("/updateNewPw")
	public String updateNewPw(String newPassword, MemberVO vo, HttpServletResponse response) {
		// 새 비밀번호 설정
		vo.setPassword(newPassword);
		memberService.updateNewPw(vo);
		PopUp.popUp(response, "비밀번호가 변경되었습니다.");
		return "login/login";
	} // updateNewPw
}
