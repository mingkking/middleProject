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
	
	String getSecretPassword(String qNo);
	 
	boolean checkPassword(String userId, String password);
	
	
	
	public List<QuestionVO> pageList(int pageNum){
		int pageStart = (pageNum - 1) * pageLimit + 1;
		List<QuestionVO> pagingList = QuestionDAOImpl.pageList(pageStart);
		
		return pagingList;
	}
	 
	public pagingVO pagingParam(int pageNum) {
		int questionCount = questionDAOImpl.questionCount();
		System.out.println(questionCount);
		
		int endPage = (int) (Math.ceil((double)questionCount / pageLimit));
		int startPage = (int)(Math.ceil((double) pageNum / blockLimit)-1) * blockLimit +1;
		System.out.println(startPage);
		
		int endPage = startPage + blockLimit -1;
		if(endPage>totalPage) {
			enPage=totalPage;
		}
		
		System.out.println(pageNum); 
        System.out.println(startPage); 
        System.out.println(totalPage); 
        System.out.println(endPage); 
        
        PagingVO pagingVO = new pagingVO();
        pagingVO.setPageNum(pageNum);
        pagingVO.setStartPage(startPage);
        pagingVO.setTotalPage(totalPage);
        pagingVO.setEndPage(endPage);
        
        return pagingVO;
	}
}
