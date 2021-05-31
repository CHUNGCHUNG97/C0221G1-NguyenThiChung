package model.service;

import model.User;

import java.util.List;

public interface IUserService {
    public void insertUser(User user);

    public User selectUserById(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id);

    public boolean updateUser(int id, User user);
}
