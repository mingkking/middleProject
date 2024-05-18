package dao.question;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.question.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis insertQuestion() 호출");
		mybatis.insert("QuestionDAO.insertQuestion", vo);
	}
	
	public void updateQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis updateQuestion() 호출");
		mybatis.update("QuestionDAO.updateQuestion", vo);
	}
	
	public void deleteQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis deleteQuestion() 호출");
		mybatis.delete("QuestionDAO.deleteQuestion", vo);
	}
	
	public QuestionVO getQuestion (QuestionVO vo) {
		System.out.println("===> Mybatis getQuestion() 호출");
		return mybatis.selectOne("QuestionDAO.getQuestion", vo);
	}
	
	public List<QuestionVO> question(HashMap map){
		System.out.println("===>Mybatis question() 호출");
		List<QuestionVO> list = mybatis.selectList("QuestionDAO.question", map);
		
		return list;
	}
	
	public void updateQuestionStatus(QuestionVO vo) {
	    System.out.println("===> Mybatis updateQuestionStatus() 호출");
	    mybatis.update("QuestionDAO.updateQuestionStatus", vo);
	}
	
	public void updateQuestionStatusToN(QuestionVO vo) {
        mybatis.update("QuestionDAO.updateQuestionStatusToN", vo);
    }
	
	public String getSecretPassword(String qNo) {
        System.out.println("===> Mybatis getSecretPassword() 호출");
        return mybatis.selectOne("QuestionDAO.getSecretPassword", qNo);
    }
	
	 @Override
	    public String getPassword(String userId) {
	    return "1234"; // 예시로 사용자의 비밀번호를 반환
	 }

}