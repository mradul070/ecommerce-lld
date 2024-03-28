package ordeManagement.src.service.Impl;

import java.util.List;
import ordeManagement.src.Model.Database;
import ordeManagement.src.Model.User;
import ordeManagement.src.service.UserService;

public class UserServiceImpl implements UserService {
    private final Database db;
    public UserServiceImpl() {
        db = Database.getInstance();
    }

    static {
        Database.getInstance().createCollection("users");
    }

    @Override
    public void createUser(User userbody) {
        db.insert("users", (User) userbody);
    }

    @Override
    public User loginUser(String email) {
        List<Object> users = db.getCollection("users");
        for (Object user: users) {
            User userObject = (User) user;
            if (userObject.getEmail().equals(email)) {
                return userObject;
            }
        }
        return null;
    }
    
    @Override
    public List<Object> getUsers() {
        return db.getCollection("users");
    }    
}
