package service.notice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.notice.NoticeDAO;
import vo.notice.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	// 공지사항 작성
	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}
	
	// 공지사항 수정
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}
	
	// 공지사항 삭제
	public void deleteNotice(NoticeVO vo) {
		noticeDAO.deleteNotice(vo);
	}
	
	// 공지사항 상세보기
	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}
	
	// 공지사항 목록보기
	@Override
	public List<NoticeVO> notice(HashMap<String, Object> map){
		return noticeDAO.notice(map);
	} 
	
	// 공지사항 페이징
	@Override
	public int getNoticeCount(HashMap<String, Object> map) {
		return noticeDAO.getNoticeCount(map);
	}
}
