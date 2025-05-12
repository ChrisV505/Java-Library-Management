package library.users;

public class StudentUser extends User {

    public StudentUser(String userName) {
        super(userName); //call parent class constructor add user name
    }

    @Override
    String getRole() {
        return "Student";
    }
    
}
