package library.users;

import library.books.Book;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private List<Book> borrowedBooks;
    private int userId;
    private String userName;

    public User(String userName) {
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
        this.userId = UserIdGenerator.generateId();
    }

    abstract String getRole(); //role will be override by student/faculty user
    public abstract void borrowBook(Book book);

    //setter for user **start**
    public int getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks; //returning full list of borrowed books per user
    }

    public String getName() {
        return userName;
    }
    //**end of setter**

    public void returnBook(Book book) {
        if(borrowedBooks.remove(book)) { //checks for current book in users list
            book.returnB(); //marks current as available again
        } else { //display error message if book not found in user list
            System.out.println("This user did not borrow this book");
        }   
    }

    @Override
    public String toString() { //method still needs diplaying id num, will add later maybe
        return String.format("Name: %s | Role: %s | Borrowed books: %d", 
        userName, getRole(),
        this.borrowedBooks.size() //using current obj arraylist to display individual book lists per user
        );
    } //returns user info
}
