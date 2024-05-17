package service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.question.QAnswerDAO;
import vo.question.QAnswerVO;

@Service("qAnswerService")
public class QAnswerServiceImpl implements QAnswerService{

	@Autowired
	private QAnswerDAO qAnswerDAO;
	
	@Override
	public void insertQuestion(QAnswerVO vo) {
		qAnswerDAO.insertQuestion(vo);
	} 
}
