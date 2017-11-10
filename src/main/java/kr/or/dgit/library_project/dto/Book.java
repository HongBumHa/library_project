package kr.or.dgit.library_project.dto;

public class Book {
	private String bookCode;
	private String bookName;
	private String author;
	private String publicName;
	private int price;
	private int amount;
	private int allRentalCount;

	public Book() {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAllRentalCount() {
		return allRentalCount;
	}

	public void setAllRentalCount(int allRentalCount) {
		this.allRentalCount = allRentalCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCode == null) ? 0 : bookCode.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((publicName == null) ? 0 : publicName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookCode == null) {
			if (other.bookCode != null)
				return false;
		} else if (!bookCode.equals(other.bookCode))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (publicName == null) {
			if (other.publicName != null)
				return false;
		} else if (!publicName.equals(other.publicName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Book [bookCode=%s, bookName=%s, author=%s, publicName=%s, price=%s, amount=%s, allRentalCount=%s]",
				bookCode, bookName, author, publicName, price, amount, allRentalCount);
	}

}
