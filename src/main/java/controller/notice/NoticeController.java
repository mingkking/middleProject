package controller.notice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.notice.NoticeService;
import vo.notice.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 공지 검색
	@RequestMapping("notice")
	public String notice(Model m,
					   String searchCondition,
					   String searchKeyword) {
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<NoticeVO> list = noticeService.notice(map);
		
		m.addAttribute("notice", list);
		
		return "notice/notice";
	}
	
	// 공지글 작성
	@RequestMapping("insertNotice")
	public String insertNotice() {
		return "notice/insertNotice";
	}
	
	// 공지글 작성 후 저장
	@RequestMapping("saveNotice")
	public String saveNotice(NoticeVO vo) {
		noticeService.insertNotice(vo);
		
		return "redirect:notice";
	}
	
	// 공지글 목록 보기
	@RequestMapping("getNotice")
	public String getNotice(NoticeVO vo, Model m) {
		NoticeVO result = noticeService.getNotice(vo);
		m.addAttribute("notice", result);
		
		return "notice/getNotice";
	}
	
	// 공지글 수정
	@RequestMapping("updateNotice")
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		return "redirect:notice";
	}
	
	// 공지글 삭제
	@RequestMapping("deleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		return "redirect:notice";
	}
}
