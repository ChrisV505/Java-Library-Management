package library.utils;

public class ReportEntry {

    private int userId;
    private String userName;
    private int bookId;
    private String bookAuthor;
    private String bookTitle;
    private String action;

    //construct each obj with a full report
    public ReportEntry(int userId, String userName, int bookId, String bookAuthor, String bookTitle, String action) {
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.action = action;
    }

    @Override
    public String toString() { //override toString for displaying report of books borrowed/returned
        return String.format("User ID: %d | Name: %s | Book ID: %d | Author - Title: %s - %s | Action: %s", 
                                    userId, userName, bookId, bookAuthor, bookTitle, action);
    }
}
