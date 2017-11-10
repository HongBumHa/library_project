package kr.or.dgit.library_project.dto;

public class BookGroup {
	private String bigGroup;
	private String bookBigGroupName;
	private int middleGroup;

	public BookGroup() {
		super();
	}

	public String getBigGroup() {
		return bigGroup;
	}

	public void setBigGroup(String bigGroup) {
		this.bigGroup = bigGroup;
	}

	public String getBookBigGroupName() {
		return bookBigGroupName;
	}

	public void setBookBigGroupName(String bookBigGroupName) {
		this.bookBigGroupName = bookBigGroupName;
	}

	public int getMiddleGroup() {
		return middleGroup;
	}

	public void setMiddleGroup(int middleGroup) {
		this.middleGroup = middleGroup;
	}

	public BookGroup(String bigGroup) {
		super();
		this.bigGroup = bigGroup;
	}

	public BookGroup(String bigGroup, int middleGroup) {
		super();
		this.bigGroup = bigGroup;
		this.middleGroup = middleGroup;
	}

}
