package library.users;

import library.books.Book;

public class FacultyUser extends User {
    private final int FACULTY_MAX_BORROW_LIMIT = 5;

    public FacultyUser(String userName) {
        super(userName); //call parent class constructor add user name
    }

    @Override
    String getRole() {
        return "Faculty";
    }

    @Override
        public void borrowBook(Book book) {
        if(getBorrowedBooks().size() >= FACULTY_MAX_BORROW_LIMIT) { //max borrow limit for faculty user 
            System.out.println("Faculty borrow limit reached (5 books)");
            return; //get out of method if limit reached
        } 
        System.out.println("Borrowing " + book.getTitle());
        book.borrowB(); //call method to mark current book unavailable
        getBorrowedBooks().add(book); //add current book to list per user
    }
}