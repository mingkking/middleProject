package dao.question;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.member.MemberVO;
import vo.question.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 사용자 문의글 작성
	public void insertQuestion(QuestionVO vo) {
		mybatis.insert("QuestionDAO.insertQuestion", vo);
	}
	
	// 사용자 문의글 수정
	public void updateQuestion(QuestionVO vo) {
		mybatis.update("QuestionDAO.updateQuestion", vo);
	}
	
	// 사용자 문의글 삭제
	public void deleteQuestion(QuestionVO vo) {
		mybatis.delete("QuestionDAO.deleteQuestion", vo);
	}
	
	// 사용자 문의글 상세보기
	public QuestionVO getQuestion (QuestionVO vo) {
		return mybatis.selectOne("QuestionDAO.getQuestion", vo);
	}
	
	// 사용자 목록보기
	public List<QuestionVO> question(HashMap<String, Object> map){
		List<QuestionVO> list = mybatis.selectList("QuestionDAO.question", map);
		
		return list;
	}
	 
	// 사용자 문의사항 페이징
	public int getQuestionCount(HashMap<String, Object> map) {
		return mybatis.selectOne("QuestionDAO.getQuestionCount", map);
	}
	
	// 답변 시 qStatus 반환
	public void updateQuestionStatus(QuestionVO vo) {
	    mybatis.update("QuestionDAO.updateQuestionStatus", vo);
	}
	
	// 삭제 삭제 시 qStatus 반환
	public void updateQuestionStatusToN(QuestionVO vo) {
        mybatis.update("QuestionDAO.updateQuestionStatusToN", vo);
    }
	
	// 비밀글 비밀번호 확인
	public String getSecretPassword(String qNo) {
        return mybatis.selectOne("QuestionDAO.getSecretPassword", qNo);
    }
	
	@Override
	public int checkPassword(MemberVO memberVO) {
		return mybatis.selectOne("QuestionDAO.getPassword", memberVO);   
	}

}