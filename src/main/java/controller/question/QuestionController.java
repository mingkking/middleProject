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
	
	// 문의글 검색 및 출력
	@RequestMapping("question")
	public String question(HttpServletResponse response,
						 Model m,
						 String searchCondition,
						 String searchKeyword,
						 String id,
						 HttpSession session) {
		
		if(session.getAttribute("logid") == null) {
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
	
	// 문의글 작성 페이지로 화면 이동
	@RequestMapping("questionWrite")
	public String insertQuestion(Model m, HttpSession session) {
		String id = (String)session.getAttribute("logid");
		m.addAttribute("id" ,id);
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
	
	// 문의글 상세 보기 화면 이동
	@RequestMapping("getQuestion")
	public String getQuestion(QuestionVO vo, Model m, HttpSession session) {
		QuestionVO result = questionService.getQuestion(vo);
		String id = (String)session.getAttribute("logid");
		m.addAttribute("id" ,id);
		m.addAttribute("question", result);
		
		return "question/getQuestion";
	}
	
	// 문의글 수정
	@RequestMapping("updateQuestion")
	public String updateQuestion(QuestionVO vo) {
		questionService.updateQuestion(vo);
		return "redirect:question";
	}
	
	// 문의글 삭제
	@RequestMapping("deleteQuestion")
	public String deleteQuestion(QuestionVO vo, Model m, HttpSession session) {
		questionService.deleteQuestion(vo);
		String id = (String)session.getAttribute("logid");
		m.addAttribute("id" ,id);
		return "redirect:question";
	}
	
	// 문의글 작성 후 저장
	@RequestMapping("saveQuestion")
	public String saveQuestion(HttpServletRequest request,HttpSession session, QuestionVO vo, String qPassword)throws Exception{
		
		//HttpSession session = request.getSession();
		String id = (String)session.getAttribute("logid");
		vo.setId(id);
		questionService.insertQuestion(vo);
		
		return "redirect:question?id="+id;
	}
}
