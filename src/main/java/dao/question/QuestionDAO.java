package dao.question;

import java.util.HashMap;
import java.util.List;

import vo.question.QuestionVO;

public interface QuestionDAO {
	
	public void insertQuestion(QuestionVO vo);
	
	public void updateQuestion(QuestionVO vo);
	
	public void deleteQuestion(QuestionVO vo);
	
	public QuestionVO getQuestion (QuestionVO vo);
	
	public List<QuestionVO> question(HashMap map);
	
	String getPassword(String userId);
}
 