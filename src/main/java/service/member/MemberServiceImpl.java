package service.member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.member.MemberDAO;
import vo.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDAO;
	
	// 회원가입
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		mDAO.insertMember(vo);
	}
 
	// 로그인
	@Override
	public int loginCheck(MemberVO vo) throws Exception {
		return mDAO.loginCheck(vo);
	}

	// 회원가입
	@Override
	public int selectCheckID(MemberVO vo) throws Exception {
		return mDAO.selectCheckID(vo);
	}

	@Override
	public int selectCheckTel(MemberVO vo) throws Exception {
		return mDAO.selectCheckTel(vo);
	}

	@Override
	public int selectCheckEmail(MemberVO vo) throws Exception {
		return mDAO.selectCheckEmail(vo);
	}
	
	//관리자 멤버 목록,리스트
//	 @Override 
//	 public List<MemberVO> getmemberList(HashMap map) { 
//		return mDAO.getmemberList(map); 
//	}
	
	//관리자 고객 확인
	public List<MemberVO> getmemberList(HashMap<String,Object>map){
		return mDAO.getmemberList(map);
	}
	
	//관리자 고객 확인 페이징
	public int getMemberCount(HashMap<String,Object>map) {
		return mDAO.getMemberCount(map);
	}
	
	//관리자 고객 상세 조회
	public MemberVO getmember(MemberVO vo) {
		return mDAO.getmember(vo);
	}
	//관리자 고객 탈퇴
	public void deletemember(MemberVO vo) {
		mDAO.deletemember(vo);
	}

	// 마이페이지 정보 조회
	public MemberVO selectMypage(MemberVO vo) {
		return mDAO.selectMypage(vo);
	}

	// 회원 탈퇴
	public int deleteMypage(MemberVO vo) {
		return mDAO.deleteMypage(vo);
	}
	
	// 회원 정보 수정
	@Override
	public int updateMypageInfo(MemberVO vo) {
		return mDAO.updateMypageInfo(vo);	
	}
	
	// 회원 정보 수정
	public void updateMypage(HashMap<String, Object> map) {
		mDAO.updateMypage(map);		
	}

	// 마이페이지 현재 비번 확인
	public int selectMypagePw(MemberVO vo) {
		return mDAO.selectMypagePw(vo);
	}
	
}
