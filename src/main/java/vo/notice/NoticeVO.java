package vo.notice;

import lombok.Data;

//@Data // Setter, Getter, toString
public class NoticeVO {
	
	private Integer nNo;		// 공지글 번호	
	private String 	nTitle;		// 공지 제목
	private String 	nContent;	// 공지 내용
	private String 	nRegdate;	// 날짜
	private String  nWriter;	// 공지 작성자
	
	
	public Integer getnNo() {
		return nNo;
	}
	public void setnNo(Integer nNo) {
		this.nNo = nNo;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnRegdate() {
		return nRegdate;
	}
	public void setnRegdate(String nRegdate) {
		this.nRegdate = nRegdate;
	}
	public String getnWriter() {
		return nWriter;
	}
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [nNo=" + nNo + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nRegdate=" + nRegdate
				+ ", nWriter=" + nWriter + "]";
	}
	 
	
	
}
