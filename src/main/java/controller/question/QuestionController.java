package controller.question;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.question.QuestionService;
import vo.question.QuestionVO;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	// 문의글 검색
	@RequestMapping("question")
	public String question(Model m,
						 String searchCondition,
						 String searchKeyword) {
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<QuestionVO> list = questionService.question(map);
		
		m.addAttribute("question", list);
		
		return "question/question";
	}
	
	// 문의글 작성 페이지로 넘어가기
	@RequestMapping("questionWrite")
	public String questionwrite() {
		return "question/questionWrite";
	}
	
	// 문의글 작성 후 저장
	@RequestMapping("saveQuestion")
	public String saveQuestion(QuestionVO vo) {
		System.out.println("insert controller애서 호출" + vo.toString());
		questionService.insertQuestion(vo);
		
		return "redirect:question";
	}
	
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
	
//	@RequestMapping("questionAnswer")
//	public String questionAnswer(QuestionVO vo) {
//		questionService.questionAnwer(vo);
//		return "redirect:question";
//	}
}
