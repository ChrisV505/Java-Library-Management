package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import library.books.Book;
import library.users.*;

public class Library {

    //encapsulating lists for library class
    private List<Book> booksRegistry;
    private List<User> usersRegistry;
    Scanner scnr = new Scanner(System.in);
    
    public Library() {
        this.booksRegistry = new ArrayList<>();
        this.usersRegistry = new ArrayList<>();    }

    //register a book into library collection
    public void addBook(Book book) {
        booksRegistry.add(book);
    }

    //register user (student or faculty)
    public void addUser(User user) {
        usersRegistry.add(user); //treat all users as the same 
    } 

    //displays all books in library collection
    public void listBooks() {
        for(Book b : booksRegistry) {
            System.out.println(b.toString()); //display infor with overriden tostring method
        }
    } 

    public void listUsers() {
        for(User u : usersRegistry) {
            System.out.println(u.toString());
        }
    }

    public void borrowBook(int userId) {

    }

    public void returnBook(int userId, int bookId) {}

    public void start() {
        boolean running = true;

        while(running) {
            
        }



    }

    private void libraryMenu() {
        System.out.println("--------------------");
        System.out.println("1. Add user");
        System.out.println("2. List users");
        System.out.println("3. Add book");
        System.out.println("4. List all books");
        System.out.println("5. Go to user menu");
        System.out.println("--------------------");
    }

    private void userMenu() {
        System.out.println("--------------------");
        System.out.println("1. Borrow book");
        System.out.println("2. List all borrowed books");
        System.out.println("3. Return book");
        System.out.println("--------------------");
    }

    private void handleUserMenu(int choice, int userId) {
        switch(choice) {
            case 1 -> borrowBook(userId);
            case 2 -> returnBook(userId);
            default -> System.out.println("Please pick a number. (1-2)");
        }
    }



}
