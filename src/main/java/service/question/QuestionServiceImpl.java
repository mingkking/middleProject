package service.question;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.question.QuestionDAO;
import vo.paging.PagingVO;
import vo.question.QuestionVO;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;
	
	// 문의글 작성
	@Override
	public void insertQuestion(QuestionVO vo) {
		questionDAO.insertQuestion(vo);
	}
	
	// 문의글 수정
	public void updateQuestion(QuestionVO vo) {
		questionDAO.updateQuestion(vo);
	}
	
	// 문의글 삭제
	public void deleteQuestion(QuestionVO vo) {
		questionDAO.deleteQuestion(vo);
	}
	
	// 문의글 상세보기
	public QuestionVO getQuestion(QuestionVO vo) {
		return questionDAO.getQuestion(vo);
	}
	 
	// 문의글 목록보기
	public List<QuestionVO> question(HashMap <String, Object> map){
		return questionDAO.question(map);
	}
	
	// 문의사항 페이징
	public int getQuestionCount(HashMap<String, Object> map) {
		return questionDAO.getQuestionCount(map);
	}
	
	// 답변 시 Y 반환
	public void updateQuestionStatus(QuestionVO vo) {
        vo.setqStatus("Y");
        questionDAO.updateQuestionStatus(vo);
    }
	
	// 삭제 시 N 반환
	public void updateQuestionStatusToN(QuestionVO vo) {
        questionDAO.updateQuestionStatusToN(vo);
    }
	
	// 문의글 비밀글
	public String getSecretPassword(String qNo) {
	    return questionDAO.getSecretPassword(qNo);
	} 
	
	// 문의글 비밀글 비밀번호 확인
	@Override
	public boolean checkPassword(String userId, String password) {
	    String storedPassword = questionDAO.getPassword(userId);
	    return storedPassword.equals(password);
	}
	
	
}
