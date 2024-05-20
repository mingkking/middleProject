package dao.question;

import java.util.HashMap;
import java.util.List;

import vo.question.QAnswerVO;
import vo.question.QuestionVO;

public interface QAnswerDAO {

	// 관리자 답변글 작성
	public void managerInsertQuestion(QAnswerVO vo);
	
	// 관리자 답변글 수정
	public void managerUpdateQuestion(QAnswerVO vo);
	
	// 관리자 답변글 삭제
	public void managerDeleteQuestion(QAnswerVO vo);
	
	// 관리자 상세보기
	public QAnswerVO managerGetQuestion(QAnswerVO vo);
}
  