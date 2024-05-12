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
	
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		noticeDAO.deleteNotice(vo);
	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}
	
	public List<NoticeVO> notice(HashMap map){
		return noticeDAO.notice(map);
	}
}
