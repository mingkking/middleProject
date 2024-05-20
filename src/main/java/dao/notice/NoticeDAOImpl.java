package dao.notice;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.notice.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 공지사항 작성
	public void insertNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	// 공지사항 수정
	public void updateNotice(NoticeVO vo) {
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	// 공지사항 삭제
	public void deleteNotice(NoticeVO vo) {
		mybatis.delete("NoticeDAO.deleteNotice", vo);
	}
	
	// 공지사항 목록보기 
	public NoticeVO getNotice(NoticeVO vo) {
		return mybatis.selectOne("NoticeDAO.getNotice", vo);
	}
	
	// 공지사항 목록 출력
	public List<NoticeVO> notice(HashMap<String, Object> map){
		List<NoticeVO> list = mybatis.selectList("NoticeDAO.notice", map);
		return list;
	}
	
	// 공지사항 페이징
	public int getNoticeCount(HashMap<String, Object> map) {
		return mybatis.selectOne("NoticeDAO.getNoticeCount", map);
	}
}
