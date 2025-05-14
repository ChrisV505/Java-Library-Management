package library.users;

import library.books.Book;

public class StudentUser extends User {
    private final int STUDENT_MAX_BORROW_LIMIT = 2;

    public StudentUser(String userName) {
        super(userName); //call parent class constructor add user name
    }

    @Override
    String getRole() {
        return "Student";
    }

    @Override
    public void borrowBook(Book book) {
        if(getBorrowedBooks().size() >= STUDENT_MAX_BORROW_LIMIT) { //max borrow limit for student user 
            System.out.println("Student borrow limit reached (3 books)");
            return; //get out of method if limit reached
        } 
        System.out.println("Borrowing " + book.getTitle());
        book.borrowB(); //call method to mark current book unavailable
        getBorrowedBooks().add(book); //add current book to list per user
    }




    
}
