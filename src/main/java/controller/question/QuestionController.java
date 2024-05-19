package controller.question;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.question.QAnswerService;
import service.question.QuestionService;
import useful.popup.PopUp;
import vo.paging.PagingVO;
import vo.question.QAnswerVO;
import vo.question.QuestionVO;

@Controller
public class QuestionController {
   
   @Autowired
   private QuestionService questionService;
   
   @Autowired
   private QAnswerService qAnswerService;
   
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
   
   // 문의글 상세 보기 화면 이동
   @RequestMapping("getQuestion")
   public String getQuestion(QAnswerVO qAnswerVO, QuestionVO vo, Model m, HttpSession session) {
      QuestionVO result = questionService.getQuestion(vo);
      QAnswerVO result2 = qAnswerService.managerGetQuestion(qAnswerVO);
      String id = (String)session.getAttribute("logid");
      m.addAttribute("id" ,id);
      m.addAttribute("question", result);
      m.addAttribute("managerQuestion", result2);
      
      
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
   public String saveQuestion(HttpServletRequest request,HttpSession session,
                        QuestionVO vo, String qPassword,Model m,
                        HttpServletResponse response)throws Exception{
      
      String id = (String) session.getAttribute("logid");
      String qSecret = request.getParameter("qSecret"); // 사용자가 입력한 비밀번호 가져오기
      boolean isPasswordCorrect = questionService.checkPassword(id, qPassword);
      m.addAttribute("question", qSecret);
        if (isPasswordCorrect) {
            vo.setId(id);
            vo.setqSecret(qSecret); // 사용자가 입력한 비밀번호 설정
            questionService.insertQuestion(vo);
            return "redirect:question?id=" + id;
        } else {
           // JavaScript를 사용하여 팝업 창을 띄운 후에 페이지를 리다이렉트
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('비밀번호가 틀렸습니다.');"
            + " window.location.href='question?id=" + id + "';</script>");
            out.flush();
            return null; // 리다이렉트 후에는 더 이상의 처리가 필요하지 않으므로 null을 반환
        }
    }
   
   // 관리자 문의글 검색 및 출력
      @RequestMapping("managerQuestion")
      public String managerQuestion(HttpServletResponse response,
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
         
         return "manager/managerQuestion";
      }
      
      // 관리자 문의글 상세 보기 화면 이동
      @RequestMapping("managerGetQuestion")
      public String managerGetQuestion(QAnswerVO qAnswerVO, Model m, QuestionVO vo) {
         System.out.println("qAnswerVO=" + qAnswerVO);
         QAnswerVO result = qAnswerService.managerGetQuestion(qAnswerVO);
         QuestionVO result2 = questionService.getQuestion(vo);
         m.addAttribute("managerQuestion", result);
         System.out.println("managerQuestion="+result);
         m.addAttribute("question", result2); 
         
         return "manager/managerGetQuestion";
      }
      
      
      
      // 관리자 답변글 작성 후 저장
      @RequestMapping("managerSaveQuestion")
      public String managerSaveQuestion(QAnswerVO vo, HttpSession session) {
         String id = (String) session.getAttribute("logid");
         vo.setId(id);
         qAnswerService.managerInsertQuestion(vo);
         
          // 문의글 상태 업데이트
          QuestionVO questionVO = new QuestionVO();
          questionVO.setqNo(vo.getqNo()); // 답변 대상 문의글의 번호
          questionService.updateQuestionStatus(questionVO);
          
         return "redirect:managerQuestion";
      }
      
      // 관리자 문의글 수정
      @RequestMapping("managerUpdateQuestion")
      public String managerUpdateQuestion(QAnswerVO vo) {
         qAnswerService.managerUpdateQuestion(vo);
         return "redirect:managerQuestion";
      }
      
      // 관리자 답변글 삭제
      @RequestMapping("managerDeleteQuestion")
      public String managerDeleteQuestion(QAnswerVO vo, Model m, HttpSession session) {
         qAnswerService.managerDeleteQuestion(vo);
         
          // 삭제 후 상태를 'N'으로 업데이트
          QuestionVO questionVO = new QuestionVO();
          questionVO.setqNo(vo.getqNo()); // 답변 대상 문의글의 번호
          questionService.updateQuestionStatusToN(questionVO);
          
         String id = (String)session.getAttribute("logid");
         m.addAttribute("id" ,id);
         return "redirect:managerQuestion";
      }
      
      // 서비스나 컨트롤러에서 호출하는 메서드
      public void updateQuestionStatus(QuestionVO vo) {
          vo.setqStatus("Y"); // qStatus를 "Y"로 설정
          questionService.updateQuestionStatus(vo); // DAO에서 updateQuestionStatus 메서드 호출
      }
      
      @RequestMapping("checkQSecret")
      public String checkQSecret(QuestionVO vo, QAnswerVO qAnswerVO, Model m, HttpSession session) {
    	  QuestionVO result = questionService.getQuestion(vo);
          QAnswerVO result2 = qAnswerService.managerGetQuestion(qAnswerVO);
          String id = (String)session.getAttribute("logid");
          m.addAttribute("id" ,id);
          m.addAttribute("question", result);
          m.addAttribute("managerQuestion", result2);
          return "question/checkQSecret";
      }
      
      @RequestMapping("paging")
      	public String paging(Model model, @RequestParam(value="pageNum", required = false, defaultValue ="1") int pageNum) {
    	  List<QuestionVO> pagingList = questService.pageList(pageNum);
    	  PagingVO PagingVO = questionService.pagingParam(pageNum);
    	  model.addAttribute("questionList", pagingList);
    	  model.addAttribute("paging", PagingVO);
    	   
    	  return "paging";
      }
      
      
      

      
 }