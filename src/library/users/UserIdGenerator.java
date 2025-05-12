package library.users;

public class UserIdGenerator {
    private static int nextUserID = 1; //make static so repetition of id is avoided

    //generates unique id for each book
    public static int generateId() {
        return nextUserID++;
    }

    //allows you to see what id num comes next **just for testing**
    public static int peekNextId() {
        return nextUserID;
    }
}
