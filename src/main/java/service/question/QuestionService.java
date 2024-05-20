package service.question;

import java.util.HashMap;
import java.util.List;

import dao.question.QuestionDAOImpl;
import vo.paging.PagingVO;
import vo.question.QuestionVO;

public interface QuestionService {
	
	// 문의글 등록
	void insertQuestion(QuestionVO vo);
	
	// 문의글 수정
	void updateQuestion(QuestionVO vo);
	
	// 문의글 삭제
	void deleteQuestion(QuestionVO vo);
	
	// 문의글 상세 조회
	QuestionVO getQuestion(QuestionVO vo);
	
	// 답변 시 Y 반환
	void updateQuestionStatus(QuestionVO vo);
	
	// 삭제 시 N 반환
	void updateQuestionStatusToN(QuestionVO vo);
	
	// 문의사항 목록 조회
	List<QuestionVO> question(HashMap<String, Object> map);
	
	// 문의사항 페이징
	int getQuestionCount(HashMap<String, Object> map);
	
	// 문의사항 비밀글 비밀번호
	boolean checkPassword(String userId, String password);
	 
}
