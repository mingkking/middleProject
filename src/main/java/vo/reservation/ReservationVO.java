package vo.reservation;

import java.util.Date;

import lombok.Data;

@Data
public class ReservationVO {
	private Integer rNo;
	private String id;
	private Integer pNo;
	private String rental;
	private String start_time;
	private String end_time;
	private Integer totalMoney;
	private String rStatus;
	private String rRegDate;
	private String rPayStatus;
	private String rPayMethod;
	private String rPayRegDate;
	
	//
	private String year;
	private String month;
	private String reservationCount;
	
	
	 
	public Integer getrNo() {
		return rNo;
	}

	public void setrNo(Integer rNo) {
		this.rNo = rNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getpNo() {
		return pNo;
	}

	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}

	public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public String getrRegDate() {
		return rRegDate;
	}

	public void setrRegDate(String rRegDate) {
		this.rRegDate = rRegDate;
	}
	
	public String getrPayStatus() {
		return rPayStatus;
	}

	public void setrPayStatus(String rPayStatus) {
		this.rPayStatus = rPayStatus;
	}

	public String getrPayMethod() {
		return rPayMethod;
	}

	public void setrPayMethod(String rPayMethod) {
		this.rPayMethod = rPayMethod;
	}

	public String getrPayRegDate() {
		return rPayRegDate;
	}

	public void setrPayRegDate(String rPayRegDate) {
		this.rPayRegDate = rPayRegDate;
	}



}
