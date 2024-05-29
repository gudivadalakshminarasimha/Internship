package Task_2;

import java.util.ArrayList;
import java.util.List;

public class Library implements Librarianoperations{
	private List<Book> books;
	private List<Member> members;
	public Library() {
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
	}
	
	public List<Book> getbooks() {
		return books;
	}
	public List<Member> getMembers(){
		return members;
	}
	
	public boolean issueBook(Book book,Member member) {
		return member.issueBook(book);
	}
	public boolean returnBook(Book book,Member member) {
		return member.returnBook(book);
	}
}
