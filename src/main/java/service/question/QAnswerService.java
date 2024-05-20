package service.question;

import java.util.HashMap;
import java.util.List;

import vo.question.QAnswerVO;
import vo.question.QuestionVO;

public interface QAnswerService {
	
	// 답변글 작성
	void managerInsertQuestion(QAnswerVO vo);
	
	// 답변글 수정
	void managerUpdateQuestion(QAnswerVO vo);
		
	// 답변글 삭제
	void managerDeleteQuestion(QAnswerVO vo);
	
	// 문의글 상세보기
	QAnswerVO managerGetQuestion(QAnswerVO vo);
}
  