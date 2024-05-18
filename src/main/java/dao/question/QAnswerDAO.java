package dao.question;

import java.util.HashMap;
import java.util.List;

import vo.question.QAnswerVO;
import vo.question.QuestionVO;

public interface QAnswerDAO {

	public void managerInsertQuestion(QAnswerVO vo);
	
	public void managerUpdateQuestion(QAnswerVO vo);
	
	public void managerDeleteQuestion(QAnswerVO vo);
	
	public QAnswerVO managerGetQuestion(QAnswerVO vo);
	
//	public List<QuestionVO> managerQuestion(HashMap map);
}
