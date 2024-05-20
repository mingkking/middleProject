package dao.question;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.paging.PagingVO;
import vo.question.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertQuestion(QuestionVO vo) {
		mybatis.insert("QuestionDAO.insertQuestion", vo);
	}
	
	public void updateQuestion(QuestionVO vo) {
		mybatis.update("QuestionDAO.updateQuestion", vo);
	}
	
	public void deleteQuestion(QuestionVO vo) {
		mybatis.delete("QuestionDAO.deleteQuestion", vo);
	}
	
	public QuestionVO getQuestion (QuestionVO vo) {
		return mybatis.selectOne("QuestionDAO.getQuestion", vo);
	}
	
	public List<QuestionVO> question(HashMap<String, Object> map){
		List<QuestionVO> list = mybatis.selectList("QuestionDAO.question", map);
		
		return list;
	}
	 
	public int getQuestionCount(HashMap<String, Object> map) {
		return mybatis.selectOne("QuestionDAO.getQuestionCount", map);
	}
	
	public void updateQuestionStatus(QuestionVO vo) {
	    mybatis.update("QuestionDAO.updateQuestionStatus", vo);
	}
	
	public void updateQuestionStatusToN(QuestionVO vo) {
        mybatis.update("QuestionDAO.updateQuestionStatusToN", vo);
    }
	
	public String getSecretPassword(String qNo) {
        return mybatis.selectOne("QuestionDAO.getSecretPassword", qNo);
    }
	
	 @Override
	    public String getPassword(String userId) {
	    return "1234"; // 예시로 사용자의 비밀번호를 반환
	 }

}