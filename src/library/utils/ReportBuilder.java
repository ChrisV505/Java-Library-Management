package library.utils;

// import library.Library;
import library.users.User;
import library.books.Book;

/*
 * Class to display a log used to link each user borrow/return, using Id's. 
 * if action is 1 it means the user is borrowing the book, and 2 the user is returning the book
 */
public class ReportBuilder {

    //return new reportEntry obj for each log entry
    public ReportEntry reportLog(User u, Book b, int action) { 
        String actionStr = (action == 1) ? "Borrowed" : "Returned";

        return new ReportEntry (
            u.getUserId(),
            u.getName(),
            b.getBookId(),
            b.getAuthor(),
            b.getTitle(),
            actionStr
        );
    }
}
