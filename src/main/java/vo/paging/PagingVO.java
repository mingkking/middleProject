package vo.paging;

public class PagingVO {
	private int pageNum = 1; // 현재 페이지
	private int startPage = 1; // 첫 페이지 	1 ~ 
	private int endPage = startPage + 9; // 끝 페이지    ~ 10
	private int totalPage = 1; // 총 페이지 수
	private int cnt = 6; // 데이터 목록 개수
	private int startBoard = 1; 
	private int endBoard = startBoard + cnt - 1;
	
	
	public PagingVO() {

	}

	public PagingVO(int pageNum, int countList) {
		super();
		
		if(pageNum < 1) {
			pageNum = 1;
		}
		
		this.totalPage = (int) Math.ceil((double)countList/cnt);
		
		int index = pageNum % 10 == 0 ? pageNum/10 : pageNum/10 + 1; // 페이지의 번호 확인 후 밑에 보여질 페이지 숫자를 결정
		int startPage = 1 + ((index-1) * 10); // 페이지 10개씩
		int endPage = startPage + 9;
		
		if(this.totalPage < endPage) {
			endPage = this.totalPage;
		}
		
		this.pageNum = pageNum;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startBoard = 1 + ((pageNum-1)*cnt);
		this.endBoard = startBoard + cnt - 1;
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getStartBoard() {
		return startBoard;
	}

	public void setStartBoard(int startBoard) {
		this.startBoard = startBoard;
	}

	public int getEndBoard() {
		return endBoard;
	}

	public void setEndBoard(int endBoard) {
		this.endBoard = endBoard;
	}

	
	@Override
	public String toString() {
		return "PagingVO [pageNum=" + pageNum + ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage="
				+ totalPage + ", cnt=" + cnt + ", startBoard=" + startBoard + ", endBoard=" + endBoard + "]";
	}
	
	
}
