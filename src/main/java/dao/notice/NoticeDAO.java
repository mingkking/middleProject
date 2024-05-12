package dao.notice;

import java.util.HashMap;
import java.util.List;

import vo.notice.NoticeVO;

public interface NoticeDAO {
	
	public void insertNotice(NoticeVO vo);
	
	public void updateNotice(NoticeVO vo);
	
	public void deleteNotice(NoticeVO vo);
	
	public NoticeVO getNotice(NoticeVO vo);
	
	public List<NoticeVO> notice(HashMap map);
}
