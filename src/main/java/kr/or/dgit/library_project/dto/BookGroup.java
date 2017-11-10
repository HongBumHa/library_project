package kr.or.dgit.library_project.dto;

public class BookGroup {
	private String bigGroup;
	private String bookBigGroupName;
	private int middleGroup;
	private String bookMiddleGroupName;

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

	public String getBookMiddleGroupName() {
		return bookMiddleGroupName;
	}

	public void setBookMiddleGroupName(String bookMiddleGroupName) {
		this.bookMiddleGroupName = bookMiddleGroupName;
	}

	@Override
	public String toString() {
		return String.format("BookGroup [bigGroup=%s, bookBigGroupName=%s, middleGroup=%s, bookMiddleGroupName=%s]",
				bigGroup, bookBigGroupName, middleGroup, bookMiddleGroupName);
	}

	public BookGroup() {
		super();
		// TODO Auto-generated constructor stub
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
