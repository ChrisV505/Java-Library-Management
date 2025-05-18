package library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import library.books.Book;
import library.users.*;
import library.utils.ReportBuilder;
import library.utils.ReportEntry;

public class Library {
    //encapsulating lists for library class
    private List<Book> booksRegistry;
    private Scanner scnr = new Scanner(System.in);
    User user; //initialize user to polymorph in future method
    Book book;
    UserService userService;
    ReportBuilder rb; //initialize obj only to access Report Entry
    List<ReportEntry> logs = new ArrayList<>();
    
    public Library() {
        this.booksRegistry = new ArrayList<>();    
    }

    //register a book into library collection
    public void addBook() {

        System.out.print("Please enter a author name: ");
        String authName = scnr.nextLine();

        System.out.print("Please enter book title: ");
        String bookTitle = scnr.nextLine();

        book = new Book(authName, bookTitle);
        System.out.println("Book created..." + "ID: " + book.getBookId());
        booksRegistry.add(book);
    }

    //register user (student or faculty)
    public void addUser() {
        System.out.print("Please enter your name: ");
        String name = scnr.nextLine();

        System.out.print("1 = Student | 2 = Faculty: ");
        int type = scnr.nextInt();

        user = userService.addUser(name, (type == 1)); //pass boolean for user type for student/faculty
        System.out.println("User created... " + "ID: " + user.getUserId());
    } 

    //displays all books in library collection
    public void listBooks() {
        for(Book b : booksRegistry) {
            System.out.println(b.toString()); //display information with overriden tostring method
        }
    } 

    public void listUsers() {
        for(User u : userService.getUsers()) { //iterate through each user obj
            System.out.println(u.toString());
        }
    }

    public void borrowBook() {
        System.out.print("Please enter user ID: ");
        int userId = scnr.nextInt();
        user = findUserById(userId); //search by id in arraylist

        if(user == null) {
            System.out.println("User id does not exist");
            return;
        }

        System.out.print("Please enter book ID: ");
        int bookID = scnr.nextInt();
        book = findBookById(bookID);

        if(book == null) {
            System.out.println("Book id does not exist");
            return;
        }

        if(book.getBorrowAvailability()) {
            System.out.println(book.isAvailable());
        }

        user.borrowBook(book);
        
        rb = new ReportBuilder(); //initialize obj only to access Report Entry. 
        logs.add(rb.reportLog(user, book, 1)); //Pass '1' for borrow action
    }

    public void returnBook() {
        System.out.print("Please enter user ID: ");
        int userId = scnr.nextInt();
        user = findUserById(userId); //search by id in arraylist

        if(user == null) {
            System.out.println("User id does not exist");
            return;
        }

        System.out.print("Please enter book ID: ");
        int bookID = scnr.nextInt();
        book = findBookById(bookID);

        if(book == null) {
            System.out.println("Book id does not exist");
            return;
        }

        if(book.getBorrowAvailability()) {
            System.out.println("Returning borrowed book: " + book.getTitle());
            user.returnBook(book);
            rb = new ReportBuilder(); //initialize obj only to access Report Entry. 
            logs.add(rb.reportLog(user, book, 2)); //Pass '2' for return action
        } else {
            System.out.println("Book not yet borrowed");
        }
    }

    public void start() {
        boolean running = true;

        while(running) {
            libraryMenu();
            int choice = validateNum();
            scnr.nextLine(); //consume newline in system
            
            switch(choice) {
                case 1 -> addUser();
                case 2 -> listUsers();
                case 3 -> addBook(); 
                case 4 -> listBooks(); 
                case 5 -> handleUserMenu();
                case 6 -> {System.out.println("Exiting...");
                            scnr.close();
                            return;
                    }
                default -> System.out.println("Please input a valid number. (1-6)");
            }
        }
    }

    //handles displaying logs 
    private void displayAllLogs() {
        for(ReportEntry entry : logs) {
            System.out.println(entry);
        }
    }


    //validatin method for integers only
    private int validateNum() {
        while(true) {
            try{
                return scnr.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Please input a number: ");
            }
        }
    }

    private User findUserById(int userId) {
        for(User u : userService.getUsers()) {
            if(userId == u.getUserId()) {
                return u;
            }
        }
        return null;
    }

    private Book findBookById(int bookId) {
        for(Book b : booksRegistry) {
            if(bookId == b.getBookId()) {
                return b;
            }
        }
        return null;
    }

    private void libraryMenu() {
        System.out.println("--------------------");
        System.out.println("1. Add user");
        System.out.println("2. List users");
        System.out.println("3. Add book");
        System.out.println("4. List all books");
        System.out.println("5. Go to user menu");
        System.out.println("6. Exit program");
        System.out.println("--------------------");
        System.out.print("Choose an option: ");
    }

    private void userMenu() {
        System.out.println("--------------------");
        System.out.println("1. Borrow book");
        System.out.println("2. Return book");
        System.out.println("3. List all borrowed books");
        System.out.println("4. Return to main menu");
        System.out.println("--------------------");
        System.out.print("Choose an option: ");
    }

    private void handleUserMenu() {
        boolean running = true;
        while(running) {
            userMenu();
            int choice = validateNum();

            switch(choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> displayAllLogs();
                case 4 -> {
                    System.out.println("returning...");
                    return;
                }
                default -> System.out.println("Please pick a number. (1-3)");
            }
        }
    }
}