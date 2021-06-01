package model.service;

import model.bean.User;

import java.util.List;

public interface IUserService {
    public List<User> callAllUsers();

    public User getUserById(int id);

    public boolean updateUser(int id, User user);

    public void insertUserStore(User user);

    User selectUserById(int id);

    public boolean deleteUser(int id);

    public void addUserTransaction(User user, int[] permission);
}
