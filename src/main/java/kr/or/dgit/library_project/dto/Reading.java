package kr.or.dgit.library_project.dto;

public class Reading {
	private String bookName;
	private String author;
	private String publicName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	@Override
	public String toString() {
		return "Reading [bookName=" + bookName + ", author=" + author + ", publicName=" + publicName + "]";
	}
	public Reading(String bookName, String author, String publicName) {
		this.bookName = bookName;
		this.author = author;
		this.publicName = publicName;
	}
	
	public Object[] modelData() {
		return new Object[] {bookName, author, publicName};
	}
	
	public Reading() {
		
	}
}
