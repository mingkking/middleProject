package service.question;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.question.QuestionDAO;
import vo.question.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;
	
	public void insertQuestion(QuestionVO vo) {
		System.out.println("insert Service에서 호출");
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
}
