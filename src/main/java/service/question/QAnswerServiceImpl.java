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
	
	// 답변글 작성
	@Override
	public void managerInsertQuestion(QAnswerVO vo) {
		qAnswerDAO.managerInsertQuestion(vo);
	}
	
	// 답변글 수정
	public void managerUpdateQuestion(QAnswerVO vo) {
		qAnswerDAO.managerUpdateQuestion(vo);
	}
	
	// 답변글 삭제
	public void managerDeleteQuestion(QAnswerVO vo) {
		qAnswerDAO.managerDeleteQuestion(vo);
		System.out.println("ServiceImpl에서 답변 삭제 완료");
	}
	
	// 답변글 상세보기
	public QAnswerVO managerGetQuestion(QAnswerVO vo) {
		return qAnswerDAO.managerGetQuestion(vo);
	} 
}
