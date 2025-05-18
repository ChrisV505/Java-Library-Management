package library;

import library.UI.Library;

public class LibraryApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Library Management System");
        //will call start method for library
        Library ui = new Library();

        ui.start(); //calls 
    }
}
