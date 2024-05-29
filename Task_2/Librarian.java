package Task_2;

import java.util.List;

public class Librarian extends Member {

	public Librarian(int memberId, String name) {
		super(memberId, name,Integer.MAX_VALUE);
	}
	
	//this method is used to add book into library
	
	public void addBook(Library library ,Book book) {
		library.getbooks().add(book);
	}
	//this method is used to remove book into library
	public void removeBook(Library library ,Book book) {
		library.getbooks().remove(book);
	}
}
