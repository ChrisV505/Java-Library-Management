package library.users;

import library.books.Book;
import java.util.ArrayList;
import java.util.List;

abstract class User {
    private List<Book> borrowedBooks;
    private final int DEFAULT_MAX_BORROW_LIMIT = 2;
    private int userId;
    private String userName;

    public User(String userName) {
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
        this.userId = UserIdGenerator.generateId();
    }

    abstract String getRole(); //role will be override by student/faculty user

    //setter for user **start**
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return userName;
    }
    //**end of setter**

    public void borrowBook(Book book) {
        if(borrowedBooks.size() >= DEFAULT_MAX_BORROW_LIMIT) { //max borrow limit for student user 
            System.out.println("Student borrow limit reached (3 books)");
            return; //get out of method if limit reached
        } 
        System.out.println("Borrowing " + book.getTitle());
        book.borrow(); //call method to mark current book unavailable
        borrowedBooks.add(book); //add current book to list per user
    }

    public void returnBook(Book book) {
        if(borrowedBooks.remove(book)) { //checks for current book in users list
            System.out.println("Book returned: " + book.getTitle());
            book.returnBook(); //marks current as available again
        } else { //display error message if book not found in user list
            System.out.println("This student did not borrow this book");
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks; //returning full list of borrowed books per user
    }

    @Override
    public String toString() { //method still needs diplaying id num, will add later maybe
        return String.format("Name: %s | Boorowed books: %d", 
        userName,borrowedBooks.size()
        );
    } //returns user info
}
