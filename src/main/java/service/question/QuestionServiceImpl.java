package service.question;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.question.QuestionDAO;
import vo.paging.PagingVO;
import vo.question.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;
	
	@Override
	public void insertQuestion(QuestionVO vo) {
		questionDAO.insertQuestion(vo);
	}
	
	public void updateQuestion(QuestionVO vo) {
		questionDAO.updateQuestion(vo);
	}
	
	public void deleteQuestion(QuestionVO vo) {
		questionDAO.deleteQuestion(vo);
	}
	
	public QuestionVO getQuestion(QuestionVO vo) {
		return questionDAO.getQuestion(vo);
	}
	 
	public List<QuestionVO> question(HashMap map){
		return questionDAO.question(map);
	}
	
	public void updateQuestionStatus(QuestionVO vo) {
        vo.setqStatus("Y");
        questionDAO.updateQuestionStatus(vo);
    }
	
	public void updateQuestionStatusToN(QuestionVO vo) {
        questionDAO.updateQuestionStatusToN(vo);
    }
	
	public String getSecretPassword(String qNo) {
	    return questionDAO.getSecretPassword(qNo);
	}
	
	@Override
	public boolean checkPassword(String userId, String password) {
	    String storedPassword = questionDAO.getPassword(userId);
	    return storedPassword.equals(password);
	}
	
	
}
