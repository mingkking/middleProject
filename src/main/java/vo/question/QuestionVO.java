package vo.question;

public class QuestionVO {
	
	private Integer qNo;		// 문의글 번호
	private String id;			// 현재 사용자 아이디
	private String qTitle;		// 문의글 제목
	private String qContent;	// 문의글 내용
	private String qPassword;	// 사용자 비밀번호
	private String qRegdate;	// 날짜
	private String qStatus;		// 답변 여부
	private String qSecret;		// 비밀글 비밀번호
	
	
	public Integer getqNo() {
		return qNo;
	}
	public void setqNo(Integer qNo) {
		this.qNo = qNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getqSecret() {
		return qSecret;
	}
	public void setqSecret(String qSecret) {
		this.qSecret = qSecret;
	}
	
	@Override
	public String toString() {
		return "QuestionVO [qNo=" + qNo + ", id=" + id + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qPassword=" + qPassword + ", qRegdate=" + qRegdate + ", qStatus=" + qStatus + ", qSecret="
				+ qSecret + "]";
	}
	
	
	
}
