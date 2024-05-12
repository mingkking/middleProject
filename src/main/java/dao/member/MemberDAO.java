package dao.member;

import vo.member.MemberVO;

public interface MemberDAO {
	// 회원 가입
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인
	public int loginCheck(MemberVO vo) throws Exception;
	
	// 회원가입 ID 중복 검사
	public int selectCheckID(MemberVO vo) throws Exception;
	
	// 회원가입 Tel 중복 검사
	public int selectCheckTel(MemberVO vo) throws Exception;
	
	// 회원가입 email 중복 검사
	public int selectCheckEmail(MemberVO vo) throws Exception;
}
