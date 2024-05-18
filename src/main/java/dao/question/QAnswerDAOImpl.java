package dao.question;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.question.QAnswerVO;

@Repository
public class QAnswerDAOImpl implements QAnswerDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void managerInsertQuestion(QAnswerVO vo) {
		System.out.println("===> Mybatis managerInsertQuestion() 호출");
		mybatis.insert("QAnswerDAO.managerInsertQuestion", vo);
	}
	
	public void managerUpdateQuestion(QAnswerVO vo) {
		System.out.println("===> Mybatis managerUpdateQuestion() 호출");
		mybatis.update("QAnswerDAO.managerUpdateQuestion", vo);
	}
	
	public void managerDeleteQuestion(QAnswerVO vo) {
		System.out.println("===> Mybatis managerDeleteQuestion() 호출");
		mybatis.delete("QAnswerDAO.managerDeleteQuestion", vo);
	}
	
	public QAnswerVO managerGetQuestion(QAnswerVO vo) {
		System.out.println("===> Mybatis managerGetQuestion() 호출");
		QAnswerVO result = mybatis.selectOne("QAnswerDAO.managerGetQuestion", vo);
		System.out.println("result=" + result);
		return result;
	}
	
//	public List<QAnswerVO> managerQuestion(HashMap map){
//		System.out.println("===>Mybatis managerQuestion() 호출");
//		List<QAnswerVO> list = mybatis.selectList("QAnswerDAO.managerQuestion", map);
//		
//		return list;
//	}
}
