package service.notice;

import java.util.HashMap;
import java.util.List;

import vo.notice.NoticeVO;

public interface NoticeService {
	
	// 글 등록
	void insertNotice(NoticeVO vo);
	
	// 글 수정
	void updateNotice(NoticeVO vo);
	
	// 글 삭제
	void deleteNotice(NoticeVO vo);
	
	// 글 상세 조회
	NoticeVO getNotice(NoticeVO vo);
	
	// 글 목록 조회
	List<NoticeVO> notice(HashMap<String, Object> map);
	int getNoticeCount(HashMap<String, Object> map);
}
