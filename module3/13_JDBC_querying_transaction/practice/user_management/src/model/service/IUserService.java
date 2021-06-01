package model.service;

import model.User;

import java.util.List;

public interface IUserService {
    public List<User> selectAllUsers();

    public User getUserById(int id);

    public boolean updateUser(int id, User user);

    public void insertUserStore(User user);

    User selectUserById(int id);


}
