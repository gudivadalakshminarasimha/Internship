package Task_2;

public class Main {
	public static void main(String[] args) {
		
		//initialize Library
		Library library=new Library();
		
		//initialize librarian
		Librarian librarian =new Librarian(1,"narasimha");
		
		//add books to the library
		Book book1=new Book(1, "scince", "narasimha");
		Book book2=new Book(2, "English", "Prasad");
		Book book3=new Book(3, "Maths", "Surya");
		Book book4=new Book(4, "M1", "radha");
		Book book5=new Book(5, "M3", "Ram");
		Book book6=new Book(6, "Cvsm", "Sai");
		
		librarian.addBook(library, book1);
		librarian.addBook(library, book2);
		librarian.addBook(library, book3);
		librarian.addBook(library, book4);
		librarian.addBook(library, book5);
		librarian.addBook(library, book6);
		
		//initialize members
		Studentmember studentmember=new Studentmember(1, "prakesh");
		Studentmember studentmember1=new Studentmember(2, "kumar");
		Studentmember studentmember2=new Studentmember(3, "manoj");
		Teachermember teachermember=new Teachermember(1, "Surya");
		Teachermember teachermember1=new Teachermember(1, "kiran");
		
		//Add members into the library
		library.getMembers().add(studentmember);
		library.getMembers().add(studentmember1);
		library.getMembers().add(studentmember2);
		library.getMembers().add(teachermember);
		library.getMembers().add(teachermember1);
		
		//issue book to student
		System.out.println("Issuing Book to student"+ library.issueBook(book1, studentmember));
		System.out.println("Issuing Book to student"+ library.issueBook(book2, studentmember1));
		System.out.println("Issuing Book to student"+ library.issueBook(book6, studentmember2));
		System.out.println("Issuing Book to student"+ library.issueBook(book3, studentmember));
		
		//Return the book from student
		System.out.println("Returning Book to Student :"+ library.returnBook(book1, studentmember));
		
		//Issue book to teacher
		System.out.println("Issuing Book to Teacher :"+library.issueBook(book2, teachermember));
		System.out.println("Issuing Book to Teacher :"+library.issueBook(book5, teachermember1));
		System.out.println("Issuing Book to Teacher :"+library.issueBook(book4, teachermember));
		
		//display library status
		
		System.out.println("library Books :"+library.getbooks());
		System.out.println("library members"+library.getMembers());
		
	}
}
