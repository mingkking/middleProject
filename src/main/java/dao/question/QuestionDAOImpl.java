package dao.question;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.question.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis insertQuestion() 호출");
		mybatis.insert("QuestionDAO.insertQuestion", vo);
	}
	
	public void updateQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis updateQuestion() 호출");
		mybatis.update("QuestionDAO.updateQuestion", vo);
	}
	
	public void deleteQuestion(QuestionVO vo) {
		System.out.println("===> Mybatis deleteQuestion() 호출");
		mybatis.delete("QuestionDAO.deleteQuestion", vo);
	}
	
	public QuestionVO getQuestion (QuestionVO vo) {
		System.out.println("===> Mybatis getQuestion() 호출");
		return mybatis.selectOne("QuestionDAO.getQuestion", vo);
	}
	
	public List<QuestionVO> question(HashMap map){
		System.out.println("===>Mybatis question() 호출");
		List<QuestionVO> list = mybatis.selectList("QuestionDAO.question", map);
		
		return list;
	}
	
	 @Override
	    public String getPassword(String userId) {
	        // 여기서는 예시로 하드코딩된 값 사용, 실제로는 DB 등에서 비밀번호를 가져와야 함
	        return "1234"; // 예시로 사용자의 비밀번호를 반환
	 } 
}
