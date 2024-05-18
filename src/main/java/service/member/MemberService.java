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
	
	//관리자 멤버 목록 조회
	//public List<MemberVO> getmemberList(HashMap map);
	
	//관리자 멤러 목록,리스트
	int getMemberCount(HashMap<String,Object>map);
	List<MemberVO> getmemberList(HashMap<String,Object>map);
	
	//관리자 고객 상세 조회
	public MemberVO getmember(MemberVO vo);
		
	//관리자 고객 삭제
	public void deletemember(MemberVO vo);
	
	// 마이페이지 정보 조회
	public MemberVO selectMypage(MemberVO vo);
	
	// 회원 탈퇴
	public int deleteMypage(MemberVO vo);
	
	// 회원 정보 수정
	public int updateMypageInfo(MemberVO vo);
		
	// 회원 정보 수정
	public void updateMypage(HashMap<String, Object> map);
	
	// 마이페이지 현재 비번 확인
	public int selectMypagePw(MemberVO vo);
}

