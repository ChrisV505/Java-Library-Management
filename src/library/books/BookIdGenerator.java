package library.books;

public class BookIdGenerator {

    private static int nextBookID = 1; //make static so repetition of id is avoided

    //generates unique id for each book
    public static int generateId() {
        return nextBookID++;
    }

    //allows you to see what id num comes next **just for testing**
    public static int peekNextId() {
        return nextBookID;
    }




}
