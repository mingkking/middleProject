package service.notice;

import java.util.HashMap;
import java.util.List;

import vo.notice.NoticeVO;

public interface NoticeService {
	
	// 공지 등록
	void insertNotice(NoticeVO vo);
	
	// 공지 수정
	void updateNotice(NoticeVO vo);
	
	// 공지 삭제
	void deleteNotice(NoticeVO vo);
	
	// 공지 상세 조회
	NoticeVO getNotice(NoticeVO vo);
	
	// 공지 목록 조회
	List<NoticeVO> notice(HashMap<String, Object> map);
	
	// 공지사항 페이징
	int getNoticeCount(HashMap<String, Object> map);
} 
