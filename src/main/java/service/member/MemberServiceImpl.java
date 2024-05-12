package service.member;

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
	
}
