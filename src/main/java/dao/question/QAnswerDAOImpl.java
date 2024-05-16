package dao.question;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.question.QAnswerVO;

@Repository
public class QAnswerDAOImpl implements QAnswerDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertQuestion(QAnswerVO vo) {
		System.out.println("===> Mybatis managerInsertQuestion() 호출");
		mybatis.insert("QAnswerDAO.managerInsertQuestion", vo);
	}
}
