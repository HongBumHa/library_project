package kr.or.dgit.library_project.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryView {
	private String bookCode;
	private String bookName;
	private String userId;
	private String userName;
	private String author;
	private String publicName;
	private int price;
	private Date rentalDay;
	private Date returnDay;

	public HistoryView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format(
				"HistoryView [bookCode=%s, bookName=%s, userId=%s, userName=%s, author=%s, publicName=%s, price=%s, rentalDay=%s, returnDay=%s]",
				bookCode, bookName, userId, userName, author, publicName, price, rentalDay, returnDay);
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(Date rentalDay) {
		this.rentalDay = rentalDay;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}

	public Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public Date changeDate(Date date) {
		return null;
	}
	
	public Object[] toArray() {
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] {bookCode,bookName,author,publicName,price,ss.format(rentalDay),ss.format(returnDay)};
	}
}
