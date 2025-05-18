package library.users;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> usersRegistry = new ArrayList<>();
        
    public User addUser(String name, boolean isStudent) {
        //morph user type depending on type
        User user = isStudent ? new StudentUser(name) : new FacultyUser(name); 
        usersRegistry.add(user);  
        return user; 
    }

    public User findUserById(int userId) {
        for(User u : usersRegistry) {
            if(userId == u.getUserId()) {
                return u;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return usersRegistry;
    }
}
