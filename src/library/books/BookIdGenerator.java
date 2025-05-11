package library.books;

public class BookIdGenerator {

    private static int nextBookID = 1;

    //generates unique id for each book
    public static int generateId() {
        return nextBookID++;
    }

    //allows you to see what id num comes next **just for testing**
    public static int peekNextId() {
        return nextBookID;
    }




}
