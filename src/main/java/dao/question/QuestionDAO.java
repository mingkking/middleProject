package dao.question;

import java.util.HashMap;
import java.util.List;

import vo.member.MemberVO;
import vo.question.QuestionVO;

public interface QuestionDAO {
	
	// 사용자 문의사항 작성
	public void insertQuestion(QuestionVO vo);
	
	// 사용자 문의사항 수정
	public void updateQuestion(QuestionVO vo);
	
	// 사용자 문의사항 삭제
	public void deleteQuestion(QuestionVO vo);
	
	// 사용자 문의사항 상세보기
	public QuestionVO getQuestion (QuestionVO vo);
	
	// 사용자 문의사항 목록보기
	public List<QuestionVO> question(HashMap<String, Object> map);
	
	// 사용자 문의사항 페이징
	int getQuestionCount(HashMap<String, Object> map);
	
	// 답변 시 qStatus 변환
	public void updateQuestionStatus(QuestionVO vo);
	
	// 답변 삭제 시 qStatus 변환
	void updateQuestionStatusToN(QuestionVO vo);
	
	// 사용자 비밀글 비밀번호
	String getSecretPassword(String qNo);
	 
	// 사용자 비밀번호
	int checkPassword(MemberVO memberVO);   
	
}
