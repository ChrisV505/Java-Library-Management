package library.users;

import library.books.Book;;

abstract class User {
    
    private int userId;
    private String userName;

    abstract String getRole();

    //setter for user **start**
    public void getUserId() {}

    public void getName() {}

    //**end of setter**

    @Override
    public String toString() {return "";} //returns user info

    public void borrowBook(Book book) {}

    public void returnBook(Book book) {}

    public void getBorrowBooks() {}

    
}
