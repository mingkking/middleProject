package dao.member;

import java.util.HashMap;
import java.util.List;

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

	public List<MemberVO> getmemberList(HashMap map);

	public MemberVO getmember(MemberVO vo);

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
