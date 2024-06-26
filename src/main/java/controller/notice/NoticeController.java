package controller.notice;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.notice.NoticeService;
import useful.popup.PopUp;
import vo.notice.NoticeVO;
import vo.paging.PagingVO;
import vo.question.QuestionVO;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	// 사용자 공지 검색 및 출력, 페이징 
	@RequestMapping("notice")
	public String notice(Model m, String searchCondition, String searchKeyword,
						 Integer pageNum) {
		
		if(pageNum == null) {
			pageNum =1;
		}
		
		HashMap<String, Object> map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		int totalRecords = noticeService.getNoticeCount(map);
		PagingVO paging = new PagingVO(pageNum, totalRecords,5);
		map.put("startBoard", paging.getStartBoard()-1);
		map.put("cnt", paging.getCnt());
		
		List<NoticeVO> list = noticeService.notice(map);
		m.addAttribute("notice", list);
		m.addAttribute("paging", paging);
		m.addAttribute("searchCondition",searchCondition);
		m.addAttribute("searchKeyword",searchKeyword);

		return "notice/notice";
	}

	// 사용자 공지글 상세 보기 화면 이동
	@RequestMapping("getNotice")
	public String getNotice(NoticeVO vo, Model m, HttpSession session) {
		NoticeVO result = noticeService.getNotice(vo);
		String id = (String) session.getAttribute("logid");
		m.addAttribute("id", id);
		m.addAttribute("notice", result);

		return "notice/getNotice";
	}

	// 관리자 공지글 수정
	@RequestMapping("managerUpdateNotice")
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		return "forward:managerGetNotice";
	}

	// 관리자 공지글 삭제
	@RequestMapping("managerDeleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		return "redirect:managerNotice";
	}

	// 관리자 검색 및 목록 출력, 페이징
	@RequestMapping("managerNotice")
	public String managerNotice(Model m, String searchCondition, String searchKeyword, Integer pageNum) {

		if(pageNum == null) {
			pageNum =1;
		}
		
		HashMap<String, Object> map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		int totalRecords = noticeService.getNoticeCount(map);
		PagingVO paging = new PagingVO(pageNum, totalRecords,5);
		map.put("startBoard", paging.getStartBoard()-1);
		map.put("cnt", paging.getCnt());
		
		List<NoticeVO> list = noticeService.notice(map);
		m.addAttribute("notice", list);
		m.addAttribute("paging", paging);
		m.addAttribute("searchCondition",searchCondition);
		m.addAttribute("searchKeyword",searchKeyword);

		return "manager/managerNotice";
	}

	// 관리자 공지글 상세 보기 화면 이동
	@RequestMapping("managerGetNotice")
	public String managerGetNotice(NoticeVO vo, Model m) {
		NoticeVO result = noticeService.getNotice(vo);
		m.addAttribute("notice", result);

		return "manager/managerGetNotice";
	}
	
	// 관리자 공지글 작성 화면 이동
		@RequestMapping("insertNotice")
		public String insertNotice() {
			return "notice/insertNotice";
		}

		// 관리자 공지글 작성 후 저장
		@RequestMapping("managerSaveNotice")
		public String saveNotice(NoticeVO vo) {
			noticeService.insertNotice(vo);

			return "redirect:managerNotice";
		}
}
