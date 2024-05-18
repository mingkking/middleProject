package dao.question;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import vo.question.QuestionVO;

public interface QuestionDAO {
	
	public void insertQuestion(QuestionVO vo);
	
	public void updateQuestion(QuestionVO vo);
	
	public void deleteQuestion(QuestionVO vo);
	
	public QuestionVO getQuestion (QuestionVO vo);
	
	public List<QuestionVO> question(HashMap map);
	
	public void updateQuestionStatus(QuestionVO vo);
	
	void updateQuestionStatusToN(QuestionVO vo);
	
	String getSecretPassword(String qNo);
	
	String getPassword(String userId);
	
}
