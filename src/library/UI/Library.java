package library.UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import library.books.Book;
import library.books.BookService;
import library.users.*;
import library.utils.ReportBuilder;
import library.utils.ReportEntry;
import library.utils.ReportService;

public class Library {
    //encapsulating lists for library class
    private Scanner scnr = new Scanner(System.in);
    private User user; //initialize user to polymorph in future method
    private Book book;
    private UserService userService;
    private BookService bookService;
    private MenuHandler mh = new MenuHandler();
    private ReportService rs = new ReportService();

    //register a book into library collection
    private void addBook() {
        System.out.print("Please enter a author name: ");
        String authName = scnr.nextLine();

        System.out.print("Please enter book title: ");
        String bookTitle = scnr.nextLine();

        book = bookService.addBook(authName, bookTitle);
        System.out.println("Book created..." + "ID: " + book.getBookId());
    }

    //register user (student or faculty)
    private void addUser() {
        System.out.print("Please enter your name: ");
        String name = scnr.nextLine();

        System.out.print("1 = Student | 2 = Faculty: ");
        int type = scnr.nextInt();

        user = userService.addUser(name, (type == 1)); //pass boolean for user type for student/faculty
        System.out.println("User created... " + "ID: " + user.getUserId());
    } 

    //displays all books in library collection
    private void listBooks() {
        for(Book b : bookService.getBooks()) {
            System.out.println(b.toString()); //display information with overriden tostring method
        }
    } 

    private void listUsers() {
        for(User u : userService.getUsers()) { //iterate through each user obj
            System.out.println(u.toString());
        }
    }

    private void borrowBook() {
        System.out.print("Please enter user ID: ");
        int userId = scnr.nextInt();
        user = userService.findUserById(userId); //search by id in arraylist

        if(user == null) {
            System.out.println("User id does not exist");
            return;
        }

        System.out.print("Please enter book ID: ");
        int bookID = scnr.nextInt();
        book = bookService.findBookById(bookID);

        if(book == null) {
            System.out.println("Book id does not exist");
            return;
        }

        if(book.getBorrowAvailability()) {
            System.out.println(book.isAvailable());
        }

        user.borrowBook(book);
        rs.log(user, book, 1); //Pass '1' for borrow action
    }

    private void returnBook() {
        System.out.print("Please enter user ID: ");
        int userId = scnr.nextInt();
        user = userService.findUserById(userId); //search by id in arraylist

        if(user == null) {
            System.out.println("User id does not exist");
            return;
        }

        System.out.print("Please enter book ID: ");
        int bookID = scnr.nextInt();
        book = bookService.findBookById(bookID);

        if(book == null) {
            System.out.println("Book id does not exist");
            return;
        }

        if(book.getBorrowAvailability()) {
            System.out.println("Returning borrowed book: " + book.getTitle());
            user.returnBook(book);
            rs.log(user, book, 2); //Pass '2' for return action
        } else {
            System.out.println("Book not yet borrowed");
        }
    }

    public void start() { //public to be accessed by main 
        boolean running = true;

        while(running) {
            mh.libraryMenu();
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
        for(ReportEntry entry : rs.getLogs()) {
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

    private void handleUserMenu() {
        boolean running = true;
        while(running) {
            mh.userMenu();
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