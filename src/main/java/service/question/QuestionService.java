package service.question;

import java.util.HashMap;
import java.util.List;

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
	
	// 글 목록 조회
	List<QuestionVO> question(HashMap map);
}
