package Task_2;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int memberId;
	private String name;
	private int maxBookIssued;
	private List<Book> currentIssuedBooks;
	
	
	public Member(int memberId, String name, int maxBookIssued) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.maxBookIssued = maxBookIssued;
		this.currentIssuedBooks = new ArrayList<>();
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBookIssued() {
		return maxBookIssued;
	}
	public void setMaxBookIssued(int maxBookIssued) {
		this.maxBookIssued = maxBookIssued;
	}
	public List<Book> getCurrentIssuedBooks() {
		return currentIssuedBooks;
	}
	public void setCurrentIssuedBooks(List<Book> currentIssuedBooks) {
		this.currentIssuedBooks = currentIssuedBooks;
	}
	@Override
	public String toString() {
		return "\n Member [memberId=" + memberId + ", name=" + name + ", maxBookIssued=" + maxBookIssued
				+ ", currentIssuedBooks=" + currentIssuedBooks + "]";
	}
	
	//this method used to issue book to student or teacher
	public boolean issueBook(Book book) {
		if(currentIssuedBooks.size()<maxBookIssued &&!book.isIssued()) {
			currentIssuedBooks.add(book);
			book.setIssued(true);
			return true;
		}
		return false;
	}
	//this method used to return book from student or teacher
	public boolean returnBook(Book book) {
		if(currentIssuedBooks.remove(book)) {
			book.setIssued(false);
			return true;
		}
		return false;
	}
}
