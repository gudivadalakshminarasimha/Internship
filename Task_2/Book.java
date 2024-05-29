package Task_2;

public class Book {
	int bookId;
	String title;
	String author;
	boolean isIssued;
	public Book(int bookId, String title, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	@Override
	public String toString() {
		return "\n book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isIssued=" + isIssued + "]";
	}
	
	

}
