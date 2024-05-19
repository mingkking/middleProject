package service.question;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.question.QAnswerDAO;
import vo.question.QAnswerVO;

@Service("qAnswerService")
public class QAnswerServiceImpl implements QAnswerService{

	@Autowired
	private QAnswerDAO qAnswerDAO;
	
	@Override
	public void managerInsertQuestion(QAnswerVO vo) {
		qAnswerDAO.managerInsertQuestion(vo);
	}
	
	public void managerUpdateQuestion(QAnswerVO vo) {
		qAnswerDAO.managerUpdateQuestion(vo);
	}
	
	public void managerDeleteQuestion(QAnswerVO vo) {
		qAnswerDAO.managerDeleteQuestion(vo);
		System.out.println("ServiceImpl에서 답변 삭제 완료");
	}
	
	public QAnswerVO managerGetQuestion(QAnswerVO vo) {
		return qAnswerDAO.managerGetQuestion(vo);
	}
	 
//	public List<QAnswerVO> managerQuestion(HashMap map){
//		return qAnswerDAO.managerQuestion(map);
//	}
}
