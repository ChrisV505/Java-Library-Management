package library.books;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> booksRegistry = new ArrayList<>();

    //getter
    public List<Book> getBooks() {
        return booksRegistry;
    }

    public Book addBook(String name, String title) {
        //morph user type depending on type
        Book book = new Book(name, title);
        booksRegistry.add(book);  
        return book; 
    }

    public Book findBookById(int bookId) {
        for(Book b : booksRegistry) {
            if(bookId == b.getBookId()) {
                return b;
            }
        }
        return null;
    }
}