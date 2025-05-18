package library.books;

public class Book {
    private String author;
    private String title;
    private int bookId;
    private boolean isAvailable;

    //defines all informatino needed per book
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.bookId = BookIdGenerator.generateId();
        this.isAvailable = false;
    }

    //setters for book **below**
    public int getBookId() {
        return bookId; //returns generated id 
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    //***end of setters***

    //checks if book is currently borrowed
    public String checkAvailability() {
        if(!isAvailable) { //if false it means book is available
            return "This book is available";
        }
        else
            return "This book is not available";
    }

    //marks the books as borrowed
    public void borrowB() {
            isAvailable = true; //call this method when book gets borrow by user
    }

    public void returnB() {
        isAvailable = false; //call this method when book become available
    }

    @Override
    public String toString() { //method still needs diplaying id num, will add later maybe
        return String.format("Author: %s | Book Title: %s | %s",
        author, title, 
        checkAvailability() //displays book availabilitys
        );
    } //display book info
}
