package controller.question;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.question.QuestionService;
import useful.popup.PopUp;
import vo.question.QuestionVO;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	// 문의글 검색
	@RequestMapping("question")
	public String question(HttpServletResponse response,
						 Model m,
						 String searchCondition,
						 String searchKeyword,
						 String id) {
		
		if(id.equals("") || id == null) {
			PopUp.popUp(response, "로그인 후 이용가능합니다.");
			return "login/login";
		}
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<QuestionVO> list = questionService.question(map);
		
		m.addAttribute("question", list);
		
		return "question/question";
	}
	
	// 문의글 작성 페이지로 넘어가기
	@RequestMapping("questionWrite")
	public String insertQuestion() {
		return "question/questionWrite";
	}
	
//	// 문의글 작성 후 저장
//	@RequestMapping("saveQuestion")
//	public String saveQuestion(QuestionVO vo) {
//		System.out.println("insert controller애서 호출" + vo.toString());
//		questionService.insertQuestion(vo);
//		
//		return "redirect:question";
//	}
	
	// 문의글 목록 보기
	@RequestMapping("getQuestion")
	public String getQuestion(QuestionVO vo, Model m) {
		QuestionVO result = questionService.getQuestion(vo);
		m.addAttribute("question", result);
		
		return "question/getQuestion;";
	}
	
	// 문의글 수정
	@RequestMapping("updateQuestion")
	public String updateQuestion(QuestionVO vo) {
		questionService.updateQuestion(vo);
		return "redirect:question";
	}
	
	// 문의글 삭제
	@RequestMapping("deleteQuestion")
	public String deleteQuestion(QuestionVO vo) {
		questionService.deleteQuestion(vo);
		return "redirect:question";
	}
	
	@RequestMapping("saveQuestion")
	public String saveQuestion(HttpServletRequest request,HttpSession session, QuestionVO vo)throws Exception{
		
		//HttpSession session = request.getSession();
		String id = (String)session.getAttribute("logid");
		
		System.out.println("================================");
		System.out.println("세션에 저장되어있는 아이디" + id);
		System.out.println("================================");
		
		System.out.println("saveQuestion() 호출" + vo.toString());
		
		return "question/question";
	}
}
