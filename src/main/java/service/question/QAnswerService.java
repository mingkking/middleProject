package service.question;

import java.util.HashMap;
import java.util.List;

import vo.question.QAnswerVO;
import vo.question.QuestionVO;

public interface QAnswerService {
	
	void managerInsertQuestion(QAnswerVO vo);
	
	// 글 수정
	void managerUpdateQuestion(QAnswerVO vo);
		
	// 글 삭제
	void managerDeleteQuestion(QAnswerVO vo);
	
	QAnswerVO managerGetQuestion(QAnswerVO vo);
	
//	List<QAnswerVO> managerQuestion(HashMap map);
}
