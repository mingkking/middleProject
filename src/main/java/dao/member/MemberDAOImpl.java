package dao.member;

import java.util.HashMap;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import dao.member.MemberDAO;
import vo.member.MemberVO;

@Repository("mDAO")
public class MemberDAOImpl implements MemberDAO{
		
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원 가입
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	// 로그인
	public int loginCheck(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.loginCheck", vo);
	}

	// 회원가입 ID 중복 검사
	@Override
	public int selectCheckID(MemberVO vo) throws Exception {
		return mybatis.selectOne("MemberDAO.selectCheckID", vo);
	}

	@Override
	public int selectCheckTel(MemberVO vo) throws Exception {
		return mybatis.selectOne("MemberDAO.selectCheckTel", vo);
	}

	@Override
	public int selectCheckEmail(MemberVO vo) throws Exception {
		return mybatis.selectOne("MemberDAO.selectCheckEmail", vo);
	}
	
	//관리자 고객리스트
	public List<MemberVO> getmemberList(HashMap<String,Object>map) {	
		List<MemberVO> list = mybatis.selectList("MemberDAO.getmemberList", map);
		return list;
	}
	
	//관리자 고객리스트 페이징처리
	public int getMemberCount(HashMap<String,Object>map) {
		return mybatis.selectOne("MemberDAO.getMemberCount",map);
	}
	
	//관리자 고객 상세조회
	public MemberVO getmember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getmember", vo);
	}
	
	//관리자 고객 탈퇴
	public void deletemember(MemberVO vo) {
		mybatis.delete("MemberDAO.deletemember",vo);
	}

	// 마이페이지 정보 조회
	public MemberVO selectMypage(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.selectMypage", vo);
	}

	// 회원 탈퇴
	public int deleteMypage(MemberVO vo) {
		return mybatis.delete("MemberDAO.deleteMypage", vo);
		
	}

	// 회원 정보 수정
	@Override
	public int updateMypageInfo(MemberVO vo) {
		return mybatis.update("MemberDAO.updateMypageInfo", vo);
	}
		
	// 회원 정보 수정
	public void updateMypage(HashMap<String, Object> map) {
		System.out.println(map.get("password2"));
		System.out.println(map.get("vo").toString());
		mybatis.update("MemberDAO.updateMypage", map);
		
	}

	// 마이페이지 현재 비번 확인
	public int selectMypagePw(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.selectMypagePw", vo);
	}

	// 아이디 찾기
	public MemberVO emailCodeId(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.emailCodeId", vo);
	}

	// 비밀번호 찾기
	public MemberVO selectPw(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.selectPw", vo);
	}

	// 비밀번호 찾기 후 수정
	public int updateNewPw(MemberVO vo) {
		return mybatis.update("MemberDAO.updateNewPw", vo);
	}

	
	
}
