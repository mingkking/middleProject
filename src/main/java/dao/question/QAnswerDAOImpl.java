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
	
	// 관리자 답변글 작성
	public void managerInsertQuestion(QAnswerVO vo) {
		mybatis.insert("QAnswerDAO.managerInsertQuestion", vo);
	}
	
	// 관리자 답변글 수정
	public void managerUpdateQuestion(QAnswerVO vo) {
		mybatis.update("QAnswerDAO.managerUpdateQuestion", vo);
	}
	 
	// 관리자 답변글 삭제
	public void managerDeleteQuestion(QAnswerVO vo) {
		mybatis.delete("QAnswerDAO.managerDeleteQuestion", vo);
	}
	
	// 관리자 상세보기
	public QAnswerVO managerGetQuestion(QAnswerVO vo) {
		QAnswerVO result = mybatis.selectOne("QAnswerDAO.managerGetQuestion", vo);
		return result;
	} 
}
 