package kr.or.dgit.library_project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalBook {
	private Date rentalDay;
	private String bookCode;
	private String userId;
	private Date returnDay;
	
	public Date getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(Date rentalDay) {
		this.rentalDay = rentalDay;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}

	@Override
	public String toString() {
		return String.format("RentalBook [rentalDay=%s, bookCode=%s, userId=%s, returnDay=%s]", rentalDay, bookCode,
				userId, returnDay);
	}

	public RentalBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }

	public RentalBook(String bookCode, String userId) {
		this.bookCode = bookCode;
		this.userId = userId;
	}

}
