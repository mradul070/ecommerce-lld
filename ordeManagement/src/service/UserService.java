package ordeManagement.src.service;

import java.util.List;

import ordeManagement.src.Model.User;

public interface UserService {
    public void createUser(User userbody);
    public User loginUser(String email);
    public List<Object> getUsers();
}
