package service.question;

import java.util.HashMap;
import java.util.List;

import dao.question.QuestionDAOImpl;
import vo.paging.PagingVO;
import vo.question.QuestionVO;

public interface QuestionService {
	
	// 글 등록
	void insertQuestion(QuestionVO vo);
	
	// 글 수정
	void updateQuestion(QuestionVO vo);
	
	// 글 삭제
	void deleteQuestion(QuestionVO vo);
	
	// 글 상세 조회
	QuestionVO getQuestion(QuestionVO vo);
	
	void updateQuestionStatus(QuestionVO vo);
	
	void updateQuestionStatusToN(QuestionVO vo);
	
	// 글 목록 조회
	List<QuestionVO> question(HashMap map);
	
	boolean checkPassword(String userId, String password);
	
}
