package vo.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private Integer pNo;
	private String pName;
	private String pLocation;
	private Integer pPrice;
	
	//*************************************************
	MultipartFile pPicture; // ****** type='file'의 name명과 동일
	
	private String pInfo;
	private String b_fname;		// 파일명
	private String b_realfname; // 저장된 파일이름
	private long b_fsize; // 파일크기 
	
	
	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public Integer getpPrice() {
		return pPrice;
	}
	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public String getB_fname() {
		return b_fname;
	}
	public void setB_fname(String b_fname) {
		this.b_fname = b_fname;
	}
	public String getB_realfname() {
		return b_realfname;
	}
	public void setB_realfname(String b_realfname) {
		this.b_realfname = b_realfname;
	}
	public long getB_fsize() {
		return b_fsize;
	}
	public void setB_fsize(long b_fsize) {
		this.b_fsize = b_fsize;
	}
	
	// 파일 게터 세터
	public MultipartFile getpPicture() {
		return pPicture;
	}
	public void setpPicture(MultipartFile pPicture) {
		this.pPicture = pPicture;
		
		// 업로드 파일이 있는 경우
		if( !pPicture.isEmpty()) {
			this.b_fname = pPicture.getOriginalFilename();
			this.b_fsize = pPicture.getSize();
			
			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			this.b_realfname = uuid.toString() + "_" + b_fname;
			
			// 실제파일 저장
			// 추후에 웹서버 경로를 찾아서 수정
			File f = new File("C:\\springweb\\hFileBoard\\src\\main\\webapp\\resources\\upload\\" + b_realfname);
			
			try {
				pPicture.transferTo(f);
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [pNo=" + pNo + ", pName=" + pName + ", pLocation=" + pLocation + ", pPicture=" + pPicture + ", pPrice=" + pPrice
				+ ", pInfo=" + pInfo + ", b_fname=" + b_fname + ", b_realfname=" + b_realfname + ", b_fsize=" + b_fsize
				+ "]";
	}
	
	
	
}
