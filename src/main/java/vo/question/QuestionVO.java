package vo.question;

public class QuestionVO {
	
	private Integer qNo;		// 번호
	private String  qWriter;	// 사용자 이름
	private String 	qTitle;		// 제목
	private String 	qContent;	// 내용
	private String 	qPassword;	// 비밀번호
	private String 	qRegdate;	// 날짜
	private String 	qStatus;	// Y/N
	
	public Integer getqNo() {
		return qNo;
	}
	public void setqNo(Integer qNo) {
		this.qNo = qNo;
	}
	public String getqWriter() {
		return qWriter;
	}
	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqPassword() {
		return qPassword;
	}
	public void setqPassword(String qPassword) {
		this.qPassword = qPassword;
	}
	public String getqRegdate() {
		return qRegdate;
	}
	public void setqRegdate(String qRegdate) {
		this.qRegdate = qRegdate;
	}
	public String getqStatus() {
		return qStatus;
	}
	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}
	
	@Override
	public String toString() {
		return "QuestionVO [qNo=" + qNo + ", qWriter=" + qWriter + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qPassword=" + qPassword + ", qRegdate=" + qRegdate + ", qStatus=" + qStatus + "]";
	}
	
	
	
	
}
