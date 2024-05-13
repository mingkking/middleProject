package service.member;

import java.util.HashMap;
import java.util.List;

import vo.member.MemberVO;

public interface MemberService {
	// 회원가입
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인
	public int loginCheck(MemberVO vo) throws Exception;
	
	// 회원가입 ID 중복 검사
	public int selectCheckID(MemberVO vo) throws Exception;
	
	// 회원가입 Tel 중복 검사
	public int selectCheckTel(MemberVO vo) throws Exception;
	
	// 회원가입 email 중복 검사
	public int selectCheckEmail(MemberVO vo) throws Exception;
	
	//멤버 목록 조회
	public List<MemberVO> getmemberList(HashMap map);
		
	//고객 상세 조회
	public MemberVO getmember(MemberVO vo);
		
	//고객 삭제
	public void deletemember(MemberVO vo);
}

