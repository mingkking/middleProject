package dao.notice;

import java.util.HashMap;
import java.util.List;

import vo.notice.NoticeVO;

public interface NoticeDAO {
	
	// 공지사항 작성
	public void insertNotice(NoticeVO vo);
	
	// 공지사항 수정
	public void updateNotice(NoticeVO vo);
	
	// 공지사항 삭제
	public void deleteNotice(NoticeVO vo);
	
	// 공지사항 상세보기
	public NoticeVO getNotice(NoticeVO vo);
	
	// 공지사항 목록보기
	public List<NoticeVO> notice(HashMap<String, Object> map); 
	
	// 공지사항 페이징
	int getNoticeCount(HashMap<String, Object> map);
}
