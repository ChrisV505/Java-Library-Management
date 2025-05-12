package library.users;

public class FacultyUser extends User {

    public FacultyUser(String userName) {
        super(userName); //call parent class constructor add user name
    }

    @Override
    String getRole() {
        return "Faculty";
    }
    
}
