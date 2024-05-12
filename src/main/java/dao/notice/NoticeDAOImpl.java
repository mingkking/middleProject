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
	
	public void insertNotice(NoticeVO vo) {
		System.out.println("===> Mybatis insertNotice() 호출");
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> Mybatis updateNotice() 호출");
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> Mybatis deleteNotice() 호출");
		mybatis.delete("NoticeDAO.deleteNotice", vo);
	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> Mybatis getNotice() 호출 ");
		return mybatis.selectOne("NoticeDAO.getNotice", vo);
	}
	
	public List<NoticeVO> notice(HashMap map){
		System.out.println("===> Mybatis notice() 호출");
		List<NoticeVO> list = mybatis.selectList("NoticeDAO.notice", map);
		
		return list;
	}
}
