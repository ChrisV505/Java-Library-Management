package library.books;

public class Book {
    private String author;
    private String title;
    private int bookId;
    private boolean isBorrowed;

    //defines all informatino needed per book
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.bookId = BookIdGenerator.generateId();
        this.isBorrowed = false;
    }

    //setters for book **below**
    public int getBookId() {
        return bookId; //returns generated id 
    }

    public boolean getBorrowAvailability() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    //***end of setters***

    //checks if book is currently borrowed
    public String isAvailable() {
        if(!isBorrowed) { //if false it means book is available
            return "This book is available";
        }
        else
            return "This book is not available";
    }

    //marks the books as borrowed
    public void borrowB() {
            isBorrowed = true; //call this method when book gets borrow by user
    }

    public void returnB() {
        isBorrowed = false; //call this method when book become available
    }

    @Override
    public String toString() { //method still needs diplaying id num, will add later maybe
        return String.format("Author: %s | Book Title: %s | %s",
        author, title, 
        isAvailable() //displays book availabilitys
        );
    } //display book info
}
