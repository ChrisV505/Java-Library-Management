package library.UI;

public class MenuHandler { 
    public void libraryMenu() {
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

    public void userMenu() {
        System.out.println("--------------------");
        System.out.println("1. Borrow book");
        System.out.println("2. Return book");
        System.out.println("3. List all borrowed books");
        System.out.println("4. Return to main menu");
        System.out.println("--------------------");
        System.out.print("Choose an option: ");
    }
}